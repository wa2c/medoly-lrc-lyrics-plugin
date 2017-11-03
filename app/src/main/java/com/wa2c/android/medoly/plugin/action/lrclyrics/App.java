package com.wa2c.android.medoly.plugin.action.lrclyrics;

import android.app.Application;

import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.versionUp(this);
    }
}
