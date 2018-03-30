package com.labs.cloud.core.utils;

/**
 * Created by Vikraa on 3/16/2018.
 */

public class Converter {

    public static int convertToInt(boolean status) {
        if (status) {
            return 1;
        }
        return 0;
    }

    public static boolean convertToBoolean(int i) {
        if (i > 0) {
            return true;
        }
        return false;
    }
}
