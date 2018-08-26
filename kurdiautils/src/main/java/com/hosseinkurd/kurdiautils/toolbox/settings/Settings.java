package com.hosseinkurd.kurdiautils.toolbox.settings;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.hosseinkurd.kurdiautils.R;
import com.hosseinkurd.kurdiautils.toolbox.helpers.CacheHelper;
import com.hosseinkurd.kurdiautils.toolbox.helpers.CalendarTool;
import com.hosseinkurd.kurdiautils.toolbox.helpers.LTH;
import com.hosseinkurd.kurdiautils.toolbox.helpers.WMH;
import com.hosseinkurd.kurdiautils.toolbox.utiles.CTV;
import com.hosseinkurd.kurdiautils.toolbox.utiles.TextTyper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kurdia on 4/15/17.
 */

public class Settings {

    public static final String MATCH_PASS = "^(?=.*[A-Za-z].*)(?=.*[0-9].*)[A-Za-z0-9]{8,}$";
    public static final String MATCH_MOBILE = "^(?:\\+989|09)(0|1|2|3|4|9)[0-9]{8}$";
    private static Settings instance;
    private MediaPlayer effect;

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public static String removeImageFromHtml(String value) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            value = Html.fromHtml(value.replaceAll("<img.+/(img)*>", ""), Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            value = Html.fromHtml(value.replaceAll("<img.+/(img)*>", "")).toString();
        }
        return "" + value;
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                StringBuilder h = new StringBuilder(Integer.toHexString(0xFF & aMessageDigest));
                while (h.length() < 2)
                    h.insert(0, "0");
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            LTH.eLog("ERROR_TAG", "File Link : " + e.getMessage(), e);
        }
        return "";
    }

    public String getClassName(Activity activity) {
        return activity.getLocalClassName();
    }

    public String getTag(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    public int getInt(Context context, int resId) {
        return context.getResources().getInteger(resId);
    }

    private int getDimens(Context ctx, int resId) {
        return (int) (ctx.getResources().getDimension(resId) / ctx.getResources().getDisplayMetrics().density);
    }

    public int getColor(Context ctx, int resId) {
        return ctx.getResources().getColor(resId);
    }

    public Typeface getTypeface(Context context) {
        return Settings.getInstance().getTypeface(context, context.getString(R.string.kurdia_utils_app_font_bold));
    }

    public Typeface getTypeface(Context context, int resId) {
        return Settings.getInstance().getTypeface(context, context.getString(resId));
    }

    public Typeface getTypeface(Context context, String path) {
        return Typeface.createFromAsset(context.getAssets(), path);
    }

    public String convertToPersianDate(String gregoryDate) {
        String persianDate = "";
        try {

            if (gregoryDate.isEmpty()) {
                persianDate = new CalendarTool().getIranianDate();
            } else {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                cal.setTime(sdf.parse(gregoryDate));
                persianDate = new CalendarTool(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).getIranianDate();
            }

        } catch (ParseException pe) {
            LTH.eLog("Error_TAG", "Parse Exception : " + gregoryDate);
            LTH.eLog("Error_TAG", "Parse Exception : " + pe.getMessage(), pe);
            persianDate = gregoryDate;
        } catch (Exception e) {
            LTH.eLog("Error_TAG", "Exception : " + e.getMessage(), e);
            persianDate = gregoryDate;
        }
        return persianDate;
    }

    /**
     * Hide Soft Keyboard
     */
    public void hideSoftKey(@NonNull Activity activity) {
        // ========== hides the keyboard
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public String getPhotoUriRealPath(Context context, Uri contentURI) {
        String path = "";
        if (contentURI == null) {
            return path;
        }
        Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            path = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            path = cursor.getString(idx);
        }
        if (cursor != null) {
            cursor.close();
        }
        return path;
    }

    public String getVideoUriRealPath(Context context, Uri contentURI) {
        String path = "";
        if (contentURI == null) {
            return path;
        }
        Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            path = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA);
            path = cursor.getString(idx);
        }
        if (cursor != null) {
            cursor.close();
        }
        return path;
    }

    /**
     * Strim File From Basic Uri To Custom Path
     *
     * @param tempUri Basic File Uri You Want To Change it's Path
     * @param ex      File Exception
     * @return New File Uri
     */
    public Uri streamImageFile(Context context, Uri tempUri, String ex) {
        try {
            if (ex == null) {
                ex = ".jpg";
            }
            if (ex.isEmpty()) {
                ex = ".jpg";
            }
            final String IMG_DIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Kuria";
            File filePath = new File(IMG_DIR);
            if (filePath.exists() || filePath.mkdirs()) {
                LTH.dLog("STREAM_TAG", "PICK FROM FILE, File Path : " + filePath.getAbsolutePath());
            }
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            String fileName = "CROP_" + timeStamp + "." + ex;
            LTH.dLog("STREAM_TAG", "PICK FROM FILE, Fiel Name : " + fileName);
            InputStream inputStream = new FileInputStream(new File(getPhotoUriRealPath(context, tempUri)));
            LTH.dLog("STREAM_TAG", "PICK FROM FILE, Define InputStream");
            File file = new File(IMG_DIR + "/" + fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[WMH.MAX_BUFFER_SIZE];
            int len = 0;
            LTH.dLog("STREAM_TAG", "PICK FROM FILE -> Buffer Size : " + new File(getPhotoUriRealPath(context, tempUri)).length());
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
                LTH.dLog("STREAM_TAG", "PICK FROM FILE, In Download File Length : " + len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            if (file.exists()) {
                LTH.dLog("STREAM_TAG", "PICK FROM FILE, File Exist : " + file.getAbsolutePath());
                return Uri.fromFile(file);
            } else {
                showToast(context, R.string.kurdia_utils_file_not_found_exception_message);
                LTH.dLog("STREAM_TAG", "PICK FROM FILE, File Not Exist : " + file.getAbsolutePath());
            }
            LTH.dLog("STREAM_TAG", "PICK FROM FILE, Operation Done, Do Crop");
        } catch (FileNotFoundException e) {
            LTH.eLog("STREAM_TAG", "PICK FROM FILE, FileNotFoundException : " + e.getMessage(), e);
            // showToast(context, R.string.kurdia_utils_file_not_found_exception_message);
        } catch (IOException ioE) {
            LTH.eLog("STREAM_TAG", "PICK FROM FILE, IOException : " + ioE.getMessage(), ioE);
            showToast(context, R.string.kurdia_utils_file_not_found_exception_message);
        }
        return null;
    }

    /**
     * Show Toast By Resource ID
     *
     * @param resId The resource id of the string resource to use. Can be formatted text.
     */
    public void showToast(Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public String removeHTML(String value) {
        value = "" + value;
        value = removeImageFromHtml(value);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            value = Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            value = Html.fromHtml(value).toString();
        }
        value = value.replace("<li>", " &#8226 ");
        value = value.replace("</li>", "");
        value = value.replace("<p>", "");
        value = value.replace("</p>", "<br />");
        // value = value.replace("<br />" , " \n ");
        return Html.fromHtml(value).toString();
    }

    public void playSound(Context ctx, int resId) {
        if (effect != null) {
            effect.stop();
            effect.release();
        }
        effect = MediaPlayer.create(ctx, resId);
        if (effect != null) {
            effect.start();
        }
    }

    public String toPersianNumber(int number) {
        return toPersianNumber(String.valueOf(number));
    }

    public String toPersianNumber(String strNumber) {
        String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        if (strNumber.length() == 0) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        int length = strNumber.length();
        for (int i = 0; i < length; i++) {
            char c = strNumber.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out.append(persianNumbers[number]);
            } else if (c == '٫') {
                out.append('،');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public void textTyper(CTV textView, String value) {
        TextTyper textTyper = new TextTyper();
        textTyper.setTextView(textView);
        textTyper.setText(value);
        textTyper.start();
    }

}