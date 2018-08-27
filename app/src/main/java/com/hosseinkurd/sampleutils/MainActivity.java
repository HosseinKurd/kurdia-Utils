package com.hosseinkurd.sampleutils;

import android.os.Bundle;

import com.hosseinkurd.kurdiautils.toolbox.settings.Settings;
import com.hosseinkurd.kurdiautils.views.activities.AbstractActivity;

/**
 * Created by Kurdia on 4/15/17.
 */

public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setPreView() {

    }

    @Override
    protected void setResources() {
        Settings.getInstance().showToast(getActivity(), com.hosseinkurd.kurdiautils.R.string.app_name);
    }
}