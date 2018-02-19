package com.labs.cloud.core.callback;

import java.text.ParseException;

/**
 * Created by vikra on 2/19/18.
 */

public interface Callback<T> {
    void onSuccess(T data);
    void onError(Exception e, String message);
}
