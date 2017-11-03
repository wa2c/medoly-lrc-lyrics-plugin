package com.wa2c.android.medoly.plugin.action.lrclyrics.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import com.wa2c.android.medoly.library.MedolyEnvironment;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppPrefs_;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Main activity.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @Pref
    AppPrefs_ appPrefs;

    @ViewById
    Button launchMedolyButton;

    @Click(R.id.launchSearchButton)
    void launchSearchButtonClick() {
        startActivity(new Intent(MainActivity.this, SearchActivity_.class));
    }

    @Click(R.id.launchCacheButton)
    void setLaunchCacheButtonClick() {
        startActivity(new Intent(MainActivity.this, CacheActivity_.class));
    }

    @Click(R.id.launchSettingsButton)
    void setLaunchSettingsButtonClick() {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    @Click(R.id.launchMedolyButton)
    void setLaunchMedolyButtonClick() {
        Intent intent = getPackageManager().getLaunchIntentForPackage(MedolyEnvironment.MEDOLY_PACKAGE);
        if (intent == null) {
            AppUtils.showToast(this, R.string.message_no_medoly);
            return;
        }
        startActivity(intent);
    }

    @AfterViews
    void afterViews() {
        AppUtils.versionUp(this);

        android.app.ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

}
