package com.labs.cloud.core.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.labs.cloud.core.base.BaseModel;
import com.labs.cloud.core.utils.Converter;

/**
 * Created by Vikraa on 3/14/2018.
 */

public class Item extends BaseModel {

    private String mName;
    private int mQuantity;
    private boolean mPriority = false;
    private int mPrice;

    public static final Parcelable.Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Item() {

    }

    public Item(Parcel in) {
        setId(in.readInt());
        setTimestamp(in.readString());
        this.mName = in.readString();
        this.mQuantity = in.readInt();
        this.mPriority = Converter.convertToBoolean(in.readInt());
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        this.mQuantity = quantity;
    }

    public boolean isPriority() {
        return mPriority;
    }

    public void setPriority(boolean priority) {
        this.mPriority = priority;
    }

    public int getPrice() {
        return this.mPrice;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getTimestamp());
        dest.writeString(this.mName);
        dest.writeInt(this.mQuantity);
        dest.writeInt(Converter.convertToInt(this.mPriority));
    }

}
