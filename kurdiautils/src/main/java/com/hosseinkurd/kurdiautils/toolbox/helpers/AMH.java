package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;

/**
 * Created by Kurdia on 4/15/17.
 */

public class AMH {

    public final static String ArgItem = "ARG_ITEM";
    public final static String ArgItems = "ARG_ITEMS";
    public final static String ArgPosition = "ARG_POSITION";
    public final static String ArgResult = "ARG_RESULT";
    public final static int ArgGameQuestionResult = 913;
    public final static String ArgShotDown = "ARG_SHOT_DOWN";

    /**
     * Move To Considered Activity
     *
     * @param activity      Activity Context
     * @param activityClass Considered Activity Class
     * @param finishCurrent Pass True if You Want To Finish Current Activity
     */
    public static void moveTo(Activity activity, Class<?> activityClass, boolean finishCurrent) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
        if (finishCurrent) {
            activity.finish();
        }
    }

    public static void moveToActivityForResult(Activity activity, Class<?> activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivityForResult(intent, ArgGameQuestionResult);
    }

    public static void returnFromActivityWithResult(Activity activity, Parcelable score) {
        Intent intent = new Intent();
        intent.putExtra(ArgResult, score);
        activity.setResult(Activity.RESULT_OK, intent);
        activity.finish();
    }

    /**
     * Shot Down App
     *
     * @param activity      Activity Context
     * @param activityClass Considered Activity Class
     */
    public static void shotDown(Activity activity, Class<?> activityClass) {
        Intent intent = new Intent(activity, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ArgShotDown, true);
        activity.startActivity(intent);
        activity.finish();
    }

}