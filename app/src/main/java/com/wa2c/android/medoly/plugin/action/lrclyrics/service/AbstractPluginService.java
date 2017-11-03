package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.app.IntentService;
import android.content.Intent;

import com.wa2c.android.medoly.library.ExtraData;
import com.wa2c.android.medoly.library.MediaPluginIntent;
import com.wa2c.android.medoly.library.PropertyData;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;


/**
 *  Download intent service.
 */

public class AbstractPluginService extends IntentService {

    /** Received receiver class name. */
    public static String RECEIVED_CLASS_NAME = "RECEIVED_CLASS_NAME";
//
//    @Pref
//    protected AppPrefs_ appPrefs;

    /** Plugin intent. */
    protected MediaPluginIntent pluginIntent;
    /** Property data. */
    protected PropertyData propertyData;
    /** Received class name. */
    protected String receivedClassName;

    private boolean resultSent;

    /**
     * Constructor.
     */
    public AbstractPluginService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Logger.d("onDestroy");

        sendResult(null);
        pluginIntent = null;
    }


    protected void process(Intent intent) {
        pluginIntent = new MediaPluginIntent(intent);
        propertyData = pluginIntent.getPropertyData();
        receivedClassName = pluginIntent.getStringExtra(RECEIVED_CLASS_NAME);
        resultSent = false;
    }

    /**
     * Send result
     * @param resultProperty A result property data.
     */
    protected void sendResult(PropertyData resultProperty) {
        sendResult(resultProperty, null);
    }

    /**
     * Send result
     * @param resultProperty A result property data.
     * @param resultExtra A result extra data.
     */
    protected void sendResult(PropertyData resultProperty, ExtraData resultExtra) {
        if (!resultSent && this instanceof PluginGetLyricsService) {
            sendBroadcast(pluginIntent.createResultIntent(resultProperty, resultExtra));
            resultSent = true;
        }
    }

}
