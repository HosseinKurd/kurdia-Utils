package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.util.Log;

/**
 * Created by Kurdia on 4/15/17.
 */

public class LTH {
    private LTH() {

    }

    public static void iLog(String tag, String msg) {
        iLog(tag, msg, null);
    }

    public static void iLog(String tag, String msg, Throwable throwable) {
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            Log.i(tag, msg.substring(start, end), throwable);
        }
    }

    public static void dLog(String tag, String msg) {
        dLog(tag, msg, null);
    }

    public static void dLog(String tag, String msg, Throwable throwable) {
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            Log.d(tag, msg.substring(start, end), throwable);
        }
    }

    public static void eLog(String tag, String msg) {
        eLog(tag, msg, null);
    }

    public static void eLog(String tag, String msg, Throwable throwable) {
        int maxLogSize = 1000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            Log.e(tag, msg.substring(start, end), throwable);
        }
    }

}