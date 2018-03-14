package com.labs.cloud.core.base;

import android.content.Context;

import com.labs.cloud.core.LabApplication;
import com.labs.cloud.core.callback.Callback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by vikra on 2/19/18.
 */

public class BaseObject extends ParseObject {

    protected Context mContext;

    public BaseObject() {
        mContext = LabApplication.getContext();

    }

    public void save(final Callback callback) {
        saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                   successCallback(BaseObject.this, callback);
                } else {
                   errorCallback(e, e.getMessage(), callback);
                }
            }
        });
    }

    public void sync(final Callback callback) {
        fetchInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    callback.onSuccess(this);
                } else {
                    callback.onError(e, e.getMessage());
                }
            }
        });
    }



    private void successCallback(BaseObject data, Callback callback) {
        callback.onSuccess(data);
        unpinInBackground();
    }

    private void errorCallback(Exception e, String message, Callback callback) {
        saveEventually();
        callback.onError(e, message);
    }
}
