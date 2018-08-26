package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Html;

/**
 * Created by Kurdia on 4/15/17.
 */

public class WMH {

    public static final int MAX_STALE_CACHE_CONTROL = (24 * 60 * 60);
    public static final int MAX_BUFFER_SIZE = 1024 * 1024;
    public static final String MSG_DONE = "done";
    public static final int SUCCESS = 200;
    public static final int INVALID = 400;
    public static final int NO_EXCEPTION = 0;
    public static final int PROTOCOL_EXCEPTION = -1;
    public static final int IO_EXCEPTION = -2;
    public static final int INVALID_EXCEPTION = -3;
    public static final int EMPTY_EXCEPTION = -4;
    public static final int MODIFY_EXCEPTION = -5;
    public static final int CANCEL_EXCEPTION = -6;
    public static final int EMPTY_OFFLINE_EXCEPTION = -7;
    public static int connectTimeOutUpload = 100; // Second
    public static int readTimeOutUpload = 100; // Second
    public static int writeTimeOutUpload = 100; // Second
    public static int connectTimeOut = 20; // Second
    public static int readTimeOut = 20; // Second
    public static int writeTimeOut = 20; // Second

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return ((netInfo != null) && netInfo.isConnected());
    }

    public static String removeHTML(String value) {
        value = "" + value;
        value = Html.fromHtml(value).toString();
        value = value.replace("<li>", " &#8226 ");
        value = value.replace("</li>", "");
        value = value.replace("<p>", "");
        value = value.replace("</p>", "<br />");
        // value = value.replace("<br />" , " \n ");
        return Html.fromHtml(value).toString();
    }

    public static String removeImageFromHtml(String value) {
        // return ""+Html.fromHtml(value.replaceAll("<img.+?>", ""));
        return "" + Html.fromHtml(value.replaceAll("<img.+/(img)*>", ""));
    }

}