package com.hosseinkurd.kurdiautils.views.activities;

import com.hosseinkurd.kurdiautils.toolbox.utiles.SwipeBackLayout;
import com.hosseinkurd.kurdiautils.views.fragments.AbsSwipeFrg;

/**
 * Created by Kurdia on 4/15/17.
 */

public abstract class AbsSwipeActivity extends AbstractActivity {

    protected AbsSwipeFrg frSwipe;

    protected SwipeBackLayout swipeBackLayout;

    public abstract void setSwipeBackLayout();

    protected abstract void init();

    protected abstract void visible(boolean visible);

}