package com.wa2c.android.medoly.plugin.action.viewlyrics.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wa2c.android.medoly.library.MedolyEnvironment;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Main activity.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById
    Button launchMedolyButton;
    @ViewById
    TextView noMedolyTextView;


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
        startActivity(getMedolyIntent());
    }

    @AfterViews
    void afterViews() {
        final Intent launchIntent = getMedolyIntent();
        if (launchIntent == null) {
            launchMedolyButton.setVisibility(View.GONE);
            noMedolyTextView.setVisibility(View.VISIBLE);
        } else {
            launchMedolyButton.setVisibility(View.VISIBLE);
            noMedolyTextView.setVisibility(View.GONE);
        }
    }

    /**
     * Get Medoly intent.
     *
     * @return Intent.
     */
    private Intent getMedolyIntent() {
        return getPackageManager().getLaunchIntentForPackage(MedolyEnvironment.MEDOLY_PACKAGE);
    }

}
