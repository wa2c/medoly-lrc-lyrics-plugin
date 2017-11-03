package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.content.Intent;

import com.wa2c.android.medoly.library.MediaProperty;
import com.wa2c.android.medoly.library.PluginTypeCategory;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.activity.SearchActivity;
import com.wa2c.android.medoly.plugin.action.lrclyrics.activity.SearchActivity_;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;


/**
 *  Download intent service.
 */
@EIntentService
public class PluginRunService extends AbstractPluginService {

    /**
     * Constructor.
     */
    public PluginRunService() {
        super(PluginRunService.class.getSimpleName());
    }

    @ServiceAction
    protected void process(Intent intent) {
        super.process(intent);
        if (intent == null)

            return;
        if (!pluginIntent.hasCategory(PluginTypeCategory.TYPE_RUN)) {
            return;
        }

        try {
            openSearchScreen();
        } catch (Exception e) {
            Logger.e(e);
            AppUtils.showToast(this, R.string.error_app);
        }
    }

    /**
     * Open search lyrics screen.
     */
    private void openSearchScreen() {
        Intent searchIntent = new Intent(this, SearchActivity_.class);
        searchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (propertyData != null) {
            searchIntent.putExtra(SearchActivity.INTENT_SEARCH_TITLE, propertyData.getFirst(MediaProperty.TITLE));
            searchIntent.putExtra(SearchActivity.INTENT_SEARCH_ARTIST, propertyData.getFirst(MediaProperty.ARTIST));
            startActivity(searchIntent);
        }
    }
}
