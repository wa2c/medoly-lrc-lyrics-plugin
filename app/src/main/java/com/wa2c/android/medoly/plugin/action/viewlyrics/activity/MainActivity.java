package com.wa2c.android.medoly.plugin.action.viewlyrics.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.wa2c.android.medoly.library.MedolyEnvironment;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppPrefs_;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;

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

    @ViewById
    Spinner executeEventSpinner;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add(getString(R.string.label_spinner_event_none));
        adapter.add(getString(R.string.label_plugin_operation_media_open));
        adapter.add(getString(R.string.label_plugin_operation_play_start));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        executeEventSpinner.setAdapter(adapter);
        executeEventSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appPrefs.prefPluginEvent().put(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                executeEventSpinner.setSelection(0);
            }
        });

        executeEventSpinner.setSelection(appPrefs.prefPluginEvent().get());

    }


}
