package com.hosseinkurd.kurdiautils.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hosseinkurd.kurdiautils.toolbox.helpers.LTH;
import com.hosseinkurd.kurdiautils.toolbox.helpers.UIH;
import com.hosseinkurd.kurdiautils.toolbox.settings.Settings;
import com.hosseinkurd.kurdiautils.views.fragments.AbsBaseFrg;

/**
 * Created by Kurdia on 4/15/17.
 */

public abstract class AbstractActivity extends AppCompatActivity {

    protected static final String TAG = "TAG_TAG";

    @Override
    public void onBackPressed() {
        Settings.getInstance().hideSoftKey(getActivity());
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("width", UIH.getWidth());
        bundle.putInt("height", UIH.getHeight());
        bundle.putInt("screenDensity", UIH.getScreenDensity());
        super.onSaveInstanceState(bundle);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        UIH.setWidth(bundle.getInt("width"));
        UIH.setHeight(bundle.getInt("height"));
        UIH.setScreenDensity(bundle.getInt("screenDensity"));
    }

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        LTH.iLog(TAG, "Where am i ? " + getClass().getSimpleName());
        super.onCreate(bundle);
        UIH.getScreenDetail(getActivity());
        UIH.createDirectories(getActivity());
        setPreView();
        setResources();
    }

    /**
     * Define Codes To Run Before View Creation
     */
    protected abstract void setPreView();

    protected abstract void setResources();

    /**
     * Set Fragment to Activity
     *
     * @param f     Fragment To Replace on View, Extends {@link android.support.v4.app.Fragment}
     * @param resId UI Element Resource Id as Fragment Holder
     */
    protected void setFragment(AbsBaseFrg f, @IdRes int resId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(resId, f, f.getClass().getName())
                // .addToBackStack(f.getClass().getName())
                .commit();
    }

    /**
     * Set Fragment to Activity
     *
     * @param f     Fragment To Replace on View, Extends {@link android.support.v4.app.Fragment}
     * @param resId UI Element Resource Id as Fragment Holder
     */
    protected void setFragment(AbsBaseFrg f, @IdRes int resId, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(resId, f, f.getClass().getName());
        if (addToBackStack) {
            ft.addToBackStack(f.getClass().getName());
        }
        ft.commit();
    }

    protected Activity getActivity() {
        return this;
    }

}