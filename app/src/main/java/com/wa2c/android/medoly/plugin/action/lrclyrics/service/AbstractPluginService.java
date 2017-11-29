package com.wa2c.android.medoly.plugin.action.lrclyrics.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.wa2c.android.medoly.library.MediaPluginIntent;
import com.wa2c.android.medoly.library.PropertyData;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;


/**
 *  Download intent service.
 */

public abstract class AbstractPluginService extends IntentService {

    /** Received receiver class name. */
    public static String RECEIVED_CLASS_NAME = "RECEIVED_CLASS_NAME";

    /** Service ID.. */
    public static int SERVICE_ID = 1;
    /** Channel ID. */
    public static String CHANNEL_ID = AbstractPluginService.class.getName();



    /** Plugin intent. */
    protected MediaPluginIntent pluginIntent;
    /** Property data. */
    protected PropertyData propertyData;
    /** Received class name. */
    protected String receivedClassName;
    /** True if result sent. */
    private boolean resultSent;


    /**
     * Constructor.
     */
    public AbstractPluginService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Logger.d("onHandleIntent: " + this.getClass().getSimpleName());

        // create notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);// The user-visible name of the channel.
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_MIN);
            channel.enableLights(false);
            channel.enableVibration(false);
            channel.setBypassDnd(false);
            channel.setShowBadge(false);
            channel.setSound(null, null);
            channel.setLockscreenVisibility((Notification.VISIBILITY_SECRET));

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);

            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setCategory(Notification.CATEGORY_PROGRESS)
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.notify(SERVICE_ID, notification);
            startForeground(SERVICE_ID, notification);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Logger.d("onDestroy" + this.getClass().getSimpleName());
        stopForeground(true);
        sendResult(null);
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
        if (!resultSent && (this instanceof PluginGetLyricsService)) {
            sendResult(this, pluginIntent, resultProperty);
            resultSent = true;
        }
    }

    /**
     * Send result.
     * @param context A context.
     * @param pluginIntent A plugin intent.
     * @param resultProperty A result property data.
    */
    public static void sendResult(Context context, MediaPluginIntent pluginIntent, PropertyData resultProperty) {
        if (context == null || pluginIntent == null)
            return;
        context.sendBroadcast(pluginIntent.createResultIntent(resultProperty));
    }

}
