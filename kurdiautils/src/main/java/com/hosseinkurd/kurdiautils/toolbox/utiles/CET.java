package com.hosseinkurd.kurdiautils.toolbox.utiles;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.hosseinkurd.kurdiautils.R;
import com.hosseinkurd.kurdiautils.toolbox.settings.Settings;

/**
 * Created by Kurdia on 4/15/17.
 */

public class CET extends AppCompatEditText {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public CET(Context context) {
        super(context);
        if (!isInEditMode())
            applyAttribute(context, null);
    }

    public CET(Context context, AttributeSet attrs) {

        super(context, attrs);
        if (!isInEditMode())
            applyAttribute(context, attrs);
    }

    public CET(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            applyAttribute(context, attrs);

    }

    private void applyAttribute(Context context, AttributeSet attrs) {
        int textStyle;
        if (attrs != null) {
            textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);
        } else {
            textStyle = 0;
        }

        setTypeface(selectTypeface(context, textStyle));

    }

    private Typeface selectTypeface(Context context, int textStyle) {
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return Settings.getInstance().getTypeface(context, R.string.kurdia_utils_app_font_bold);
            case Typeface.ITALIC: // italic
                return Settings.getInstance().getTypeface(context, R.string.kurdia_utils_app_font_light);
            case Typeface.BOLD_ITALIC: // bold italic
                return Settings.getInstance().getTypeface(context, R.string.kurdia_utils_app_font_ultra_light);
            case Typeface.NORMAL: // regular
                return Settings.getInstance().getTypeface(context, R.string.kurdia_utils_app_font_italic);
            default:
                return Settings.getInstance().getTypeface(context, R.string.kurdia_utils_app_font_normal);
        }
    }

    public String getString() {
        return getText().toString();
    }

}