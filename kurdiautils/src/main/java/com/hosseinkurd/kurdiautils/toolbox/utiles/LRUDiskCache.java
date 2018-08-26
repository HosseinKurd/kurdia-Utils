package com.hosseinkurd.kurdiautils.toolbox.utiles;

import android.content.Context;
import android.content.SharedPreferences;

import com.hosseinkurd.kurdiautils.R;
import com.hosseinkurd.kurdiautils.toolbox.helpers.CacheHelper;

/**
 * Created by Kurdia on 4/15/17.
 */

public class LRUDiskCache {

    public static final String TAG = LRUDiskCache.class.getSimpleName() + "_TAG";

    private static LRUDiskCache instance;

    public static LRUDiskCache getInstance() {
        if (instance == null) {
            instance = new LRUDiskCache();
        }
        return instance;
    }

    public void setLruRestCache(Context context, String name, String content) {
        /*Calendar calendar = Calendar.newInstance();
        final int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
        name = name + "-" + DAY_OF_YEAR;*/
        long offset = System.currentTimeMillis() + (24 * 60 * 60 * 1000);
        SharedPreferences shp = context.getSharedPreferences(context.getString(R.string.kurdia_utils_shp_app), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putLong(getParentKey(name), offset);
        editor.putString(getChildKey(name), content);
        editor.apply();
        // Log.e(TAG, "saveResponse-> Name : " + name);
    }

    public String getLruRestCache(Context context, String name) {
        final String PARENT_KEY = getParentKey(name);
        final String CHILD_KEY = getChildKey(name);
        /*
        final long LRU_CACHE_KEY = Settings.newInstance().getInstance().getLong(context, PARENT_KEY, 0);
        final long CURRENT_TIME = System.currentTimeMillis();
        if(LRU_CACHE_KEY < CURRENT_TIME) {
            return "";
        }
        */

        return CacheHelper.getInstance().getString(context, CHILD_KEY, "");
        // Log.e("STORE_TAG", "getSavedResponse-> Name : " + name);
    }

    private String getParentKey(String name) {
        return name + "_" + TAG;
    }

    private String getChildKey(String name) {
        return name + "-" + TAG;
    }

}