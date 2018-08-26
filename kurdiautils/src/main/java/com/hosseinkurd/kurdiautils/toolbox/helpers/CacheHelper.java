package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.hosseinkurd.kurdiautils.R;

/**
 * Created by Kurdia on 4/15/17.
 */

public class CacheHelper {

    private static CacheHelper instance;

    private static SharedPreferences sharedPreferences;

    public static CacheHelper getInstance() {
        if (instance == null) {
            instance = new CacheHelper();
        }
        return instance;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(
                    context.getString(R.string.kurdia_utils_shp_app), Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public void clear(Context context) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }

    public void apply(Context context, int resId, String value) {
        apply(context, context.getString(resId), value);
    }

    public void apply(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void apply(Context context, int resId, int value) {
        apply(context, context.getString(resId), value);
    }

    public void apply(Context context, String key, int value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void apply(Context context, String key, long value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void apply(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getString(Context context, int resId, String defValue) {
        return getString(context, context.getString(resId), defValue);
    }

    public String getString(Context context, String key, String defValue) {
        return getSharedPreferences(context).getString(key, defValue);
    }

    public int getInteger(Context context, int resId, int defValue) {
        return getInteger(context, context.getString(resId), defValue);
    }

    public int getInteger(Context context, String key, int defValue) {
        return getSharedPreferences(context).getInt(key, defValue);
    }

    public long getLong(Context context, int resId, long defValue) {
        return getLong(context, context.getString(resId), defValue);
    }

    public long getLong(Context context, String key, long defValue) {
        return getSharedPreferences(context).getLong(key, defValue);
    }

    public boolean getBoolean(Context context, int resId, boolean defValue) {
        return getBoolean(context, context.getString(resId), defValue);
    }

    public boolean getBoolean(Context context, String key, boolean defValue) {
        return getSharedPreferences(context).getBoolean(key, defValue);
    }

    public void remove(Context context, int resId) {
        remove(context, context.getString(resId));
    }

    public void remove(Context context, String key) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove(key);
        editor.apply();
    }

}