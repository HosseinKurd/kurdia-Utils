package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.hosseinkurd.kurdiautils.R;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;

/**
 * Created by Kurdia on 4/15/17.
 */

public class UIH {

    public final static double PORTRAIT_ADAPTER_H = 0.623015873;
    public final static double PORTRAIT_H = 0.707070707;
    public final static int ASPECT_X = 1000;
    public final static int ASPECT_Y = 623;
    public static String TAG_SCR = "SCREEN_TAG";
    private static int screenDensity = 0;
    private static int width = 1;
    private static int height = 1;

    public static int getScreenDensity() {
        return screenDensity;
    }

    public static void setScreenDensity(int screenDensity) {
        UIH.screenDensity = screenDensity;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        UIH.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        UIH.height = height;
    }

    public static int setPercentW(double value) {
        return (int) (width * value);
    }

    public static int setPercentH(double value) {
        return (int) (height * value);
    }

    public static void setMargin(View v, int left, int top, int right, int bottom) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams ml_params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            ml_params.setMargins(left, top, right, bottom);
            v.requestLayout();
        } else {
            // LTH.eLog("SET_MARGIN", "View : " + v.getId() + " Has Not instanceof ViewGroup.MarginLayoutParams.");
        }
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static void createDirectories(Context context) {
        String DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        String DIR_APP = DIR_SDCARD + File.separator + "Android" + File.separator + "data" +
                File.separator + context.getPackageName() + File.separator +
                context.getString(R.string.dir_app) + File.separator;
        DIR_APP = DIR_APP.replace(File.separator + File.separator, File.separator);
        String DIR_DATE = DIR_APP + context.getString(R.string.kurdia_utils_dir_date);
        String DIR_DEV = DIR_APP + context.getString(R.string.kurdia_utils_dir_dev);
        new File(DIR_APP).mkdirs();
        new File(DIR_DATE).mkdirs();
        new File(DIR_DEV).mkdirs();
        new File(DIR_APP + context.getString(R.string.kurdia_utils_dir_one)).mkdirs();
        new File(DIR_APP + context.getString(R.string.kurdia_utils_dir_two)).mkdirs();
        new File(DIR_APP + context.getString(R.string.kurdia_utils_dir_three)).mkdirs();
        new File(DIR_APP + context.getString(R.string.kurdia_utils_dir_four)).mkdirs();
    }

    public static void getScreenDetail(Context context) {
        int screen_density;
        int wPX;
        int hPX;

        screen_density = (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK);
        UIH.screenDensity = screen_density;

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        wPX = metrics.widthPixels;
        hPX = metrics.heightPixels;
        if (wPX < hPX) {
            UIH.width = wPX;
            UIH.height = hPX;
        } else if (wPX > hPX) {
            UIH.width = hPX;
            UIH.height = wPX;
        }
    }

    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * ((float) displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static GradientDrawable getDrawableShape(int backgroundColor, int borderColor, float topRadius, float bottomRadius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[]{topRadius, topRadius, topRadius, topRadius, bottomRadius, bottomRadius, bottomRadius, bottomRadius});
        shape.setColor(backgroundColor);
        shape.setStroke(3, borderColor);
        return shape;
    }

    public static Bitmap getRoundedBitmap(Bitmap resource, float roundPx) {
        Bitmap output = Bitmap.createBitmap(resource.getWidth(), resource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, resource.getWidth(), resource.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, rect, rect, paint);
        return output;
    }

    public static Bitmap getRoundedBitmap(Context context, Bitmap resource, int pixels, boolean squareTL, boolean squareTR, boolean squareBL, boolean squareBR) {
        int w = resource.getWidth();
        int h = resource.getHeight();
        Bitmap output = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        /*final float densityMultiplier = context.getResources().getDisplayMetrics().density;*/
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, w, h);
        final RectF rectF = new RectF(rect);
        // make sure that our rounded corner is scaled appropriately
        // final float roundPx = pixels * densityMultiplier;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawRoundRect(rectF, pixels, pixels, paint);
        //draw rectangles over the corners we want to be square
        if (squareTL) {
            canvas.drawRect(0, h / 2, w / 2, h, paint);
        }
        if (squareTR) {
            canvas.drawRect(w / 2, h / 2, w, h, paint);
        }
        if (squareBL) {
            canvas.drawRect(0, 0, w / 2, h / 2, paint);
        }
        if (squareBR) {
            canvas.drawRect(w / 2, 0, w, h / 2, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, 0, 0, paint);
        return output;
    }

}