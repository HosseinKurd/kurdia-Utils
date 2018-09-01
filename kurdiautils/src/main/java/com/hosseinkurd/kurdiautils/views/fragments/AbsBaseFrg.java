package com.hosseinkurd.kurdiautils.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hosseinkurd.kurdiautils.toolbox.helpers.LTH;

/**
 * Created by Kurdia on 4/15/17.
 */

public abstract class AbsBaseFrg extends Fragment {

    protected static final String TAG = "ABS_BASE_FRAG_TAG";

    /**
     * Basic Abstract Fragment
     */
    public AbsBaseFrg() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        LTH.iLog(TAG, "Where am i ? " + getClass().getSimpleName());
        super.onCreate(savedInstanceState);
        setPreView();
    }

    /**
     * Define Codes To Run Before View Creation
     */
    protected abstract void setPreView();

    /**
     * @param view Fragment View To get UI Elements
     */
    protected abstract void setResources(View view);
}