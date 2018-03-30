package com.labs.cloud.core.utils;

/**
 * Created by Vikraa on 3/30/2018.
 */

public enum PaymentOptions {

    PAYMENT_CASH("Cash",0),
    PAYMENT_DEBIT_CARD("Debit Card",1),
    PAYMENT_CREDIT_CARD("Credit Card",2);

    private String mPaymentName;
    private int mPaymentMethodIndex;

    private PaymentOptions(String paymentName, int index) {
        this.mPaymentName = paymentName;
        this.mPaymentMethodIndex = index;
    }

    @Override
    public String toString() {
        return "Payment using " + mPaymentName;
    }

}
