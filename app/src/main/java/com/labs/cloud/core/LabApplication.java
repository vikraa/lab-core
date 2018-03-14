package com.labs.cloud.core;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;

/**
 * Created by vikra on 2/19/18.
 */

public abstract class LabApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initParse();
    }

    public static boolean storeLocalData() {
        return true;
    }

    public static Context getContext() {
        return mContext;
    }

    private void initParse() {
        if (storeLocalData()) {
            Parse.enableLocalDatastore(mContext);
        }
        Parse.initialize(mContext);
    }

}
