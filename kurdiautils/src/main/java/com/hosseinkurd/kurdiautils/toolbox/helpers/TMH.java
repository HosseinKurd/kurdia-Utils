package com.hosseinkurd.kurdiautils.toolbox.helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hosseinkurd.kurdiautils.R;

/**
 * Created by Kurdia on 4/15/17.
 */

public class TMH {
/*

    public TMH() {
        this.layoutInflater = null;
        this.typeface = null;
        this.context = null;
        this.text = "";
        type = TYPE_NORMAL;
    }

    private LayoutInflater layoutInflater;
    private Typeface typeface;
    private Context context;
    private String text;
    private int type;

    public final static int TYPE_NORMAL = 0;
    public final static int TYPE_ATTENTION = 1;
    public final static int TYPE_ERROR = 2;

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public Context getContext() {
        return context;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    private TMH(Builder builder) {
        layoutInflater = builder.layoutInflater;
        typeface = builder.typeface;
        context = builder.context;
        text = builder.text;
        type = builder.type;

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }

        View layout = null;

        switch (type) {
            case TYPE_NORMAL:
                layout = layoutInflater.inflate(R.layout.layout_toast_normal, null);
                break;
            case TYPE_ATTENTION:
                layout = layoutInflater.inflate(R.layout.layout_toast_attention, null);
                break;
            case TYPE_ERROR:
                layout = layoutInflater.inflate(R.layout.layout_toast_error, null);
                break;
        }

        if (layout != null) {
            TextView textView = (TextView) layout.findViewById(R.id.txt_toast);
            textView.setText(text);
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
        }
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    */
/**
     * {@code TMH} builder static inner class.
     *//*

    public static final class Builder {
        private LayoutInflater layoutInflater;
        private Typeface typeface;
        private Context context;
        private String text;
        private int type;

        private Builder() {

            this.layoutInflater = null;
            this.typeface = null;
            this.context = null;
            this.text = "";
            type = TYPE_NORMAL;

        }

        */
/**
         * Sets the {@code layoutInflater} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param layoutInflater the {@code layoutInflater} to set
         * @return a reference to this Builder
         *//*

        public Builder withLayoutInflater(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
            return this;
        }

        */
/**
         * Sets the {@code typeface} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param typeface the {@code typeface} to set
         * @return a reference to this Builder
         *//*

        public Builder withTypeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        */
/**
         * Sets the {@code context} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param context the {@code context} to set
         * @return a reference to this Builder
         *//*

        public Builder withContext(Context context) {
            this.context = context;
            return this;
        }

        */
/**
         * Sets the {@code text} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param text the {@code text} to set
         * @return a reference to this Builder
         *//*

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        */
/**
         * Sets the {@code type} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param type the {@code type} to set
         * @return a reference to this Builder
         *//*

        public Builder withType(int type) {
            this.type = type;
            return this;
        }

        */
/**
         * Returns a {@code TMH} built from the parameters previously set.
         *
         * @return a {@code TMH} built with parameters of this {@code TMH.Builder}
         *//*

        public TMH build() {
            return new TMH(this);
        }
    }
*/

}