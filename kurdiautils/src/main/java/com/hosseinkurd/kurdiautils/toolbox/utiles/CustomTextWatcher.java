package com.hosseinkurd.kurdiautils.toolbox.utiles;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by Kurdia on 4/15/17.
 */

public class CustomTextWatcher implements TextWatcher {

    private View view;
    private AfterTextChange afterTextChange;

    public CustomTextWatcher(View view, AfterTextChange afterTextChange) {
        this.view = view;
        this.afterTextChange = afterTextChange;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    public void afterTextChanged(Editable editable) {
        afterTextChange.onChanged(view.getId());
    }

    public interface AfterTextChange {
        void onChanged(int resId);
    }

}