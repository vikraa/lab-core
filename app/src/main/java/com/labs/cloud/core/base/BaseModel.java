package com.labs.cloud.core.base;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Vikraa on 3/15/2018.
 */

public abstract class  BaseModel implements Parcelable {

    private int mId;
    private Date mTimestamp;
    private static ClassLoader mClassLoader;

    public BaseModel() {
        mTimestamp = new Date(System.currentTimeMillis());
    }

    public void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setTimestamp(String timestamp) {

    }

    public String getTimestamp() {
        return mTimestamp.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
