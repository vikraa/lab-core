package com.labs.cloud.core.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.labs.cloud.core.base.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vikraa on 3/15/2018.
 */

public class Order extends BaseModel {

    private List<Item> mOrderItems;

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public Order(Parcel in) {
        setId(in.readInt());
        setTimestamp(in.readString());
        mOrderItems = new ArrayList<>();
        in.readList(mOrderItems, Item.class.getClassLoader());
    }

    public Order() {
        mOrderItems = new ArrayList<>();
    }

    public List<Item> getOrderItems() {
        return mOrderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.mOrderItems = orderItems;
    }

    public void addOrderItem(List<Item> additionalItems) {
        for(Item i : additionalItems) {
            this.mOrderItems.add(i);
        }
    }

    public void addOrderItem(Item additionalItems) {
        this.mOrderItems.add(additionalItems);
    }

    public void removeOrderItem(Item item) {
        for(Item i : this.mOrderItems) {
            if (i.getId() == item.getId()) {
                mOrderItems.remove(i);
                break;
            }
        }
    }

    public void removeOrderItem(List<Item> removeItems) {
        HashMap<Integer, Item> removeItemMap = new HashMap<>();
        for (Item i : removeItems) {
            removeItemMap.put(i.getId(), i);
        }

        for(Item i : this.mOrderItems) {
            if (removeItemMap.containsKey(i.getId())) {
                this.mOrderItems.remove(i);
                removeItemMap.remove(i.getId());
            }
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getTimestamp());
        dest.writeList(this.mOrderItems);
    }
}
