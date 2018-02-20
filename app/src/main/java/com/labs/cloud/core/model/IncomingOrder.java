package com.labs.cloud.core.model;

import com.labs.cloud.core.base.BaseObject;
import com.labs.cloud.core.callback.Callback;
import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by vikra on 2/20/18.
 */
@ParseClassName("order")
public class IncomingOrder extends BaseObject {

    private static String ORDER_ID = "order_id";
    private int mOrderId;

    private List<OrderItem> mOrderItems;

    public IncomingOrder() {
        super();
    }

    public void setOrderItems(List<OrderItem> items) {
        put("order_item",items);
    }

    public void getOrderItems(final Callback<IncomingOrder> callback) {
        ParseQuery<IncomingOrder> queryOrders = ParseQuery.getQuery("order");
        queryOrders.getInBackground(getObjectId(), new GetCallback<IncomingOrder>() {
            @Override
            public void done(IncomingOrder data, ParseException e) {
                if (e == null) {
                    callback.onSuccess(data);
                } else {
                    callback.onError(e, e.getMessage());
                }
            }
        });

    }

    public void setOrderItem(OrderItem item) {

    }



}
