package com.labs.cloud.core.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.labs.cloud.core.base.BaseModel;
import com.labs.cloud.core.utils.PaymentOptions;

/**
 * Created by Vikraa on 3/30/2018.
 */

public class Payment extends BaseModel {

    private PaymentOptions mPaymentOptions;
    private Order mOrderItem;

    public static final Parcelable.Creator<Payment> CREATOR = new Creator<Payment>() {
        @Override
        public Payment createFromParcel(Parcel source) {
            return new Payment(source);
        }

        @Override
        public Payment[] newArray(int size) {
            return new Payment[size];
        }
    };

    Payment(Parcel in) {

    }

    public void setOrderItem(Order order) {

    }

    public void setPaymentMethod(PaymentOptions paymentOptions) {

    }

    public PaymentOptions getPaymentOptions() {
        return mPaymentOptions;
    }

    public int getTotalPayment() {
        int totalPrice = 0;
        for (Item i : mOrderItem.getOrderItems()) {
            totalPrice += i.getPrice();
        }

        return totalPrice;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
