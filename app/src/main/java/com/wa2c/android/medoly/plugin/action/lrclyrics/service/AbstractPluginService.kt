package com.wa2c.android.medoly.plugin.action.lrclyrics.service

import android.annotation.SuppressLint
import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import com.wa2c.android.medoly.library.ExtraData

import com.wa2c.android.medoly.library.MediaPluginIntent
import com.wa2c.android.medoly.library.PropertyData
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Prefs


/**
 * Plugin service base.
 */
abstract class AbstractPluginService(name: String) : IntentService(name) {

    /** Context.  */
    protected lateinit var context: Context
    /** Preferences.  */
    protected lateinit var prefs: Prefs
    /** Plugin intent.  */
    protected lateinit var pluginIntent: MediaPluginIntent
    /** Property data.  */
    protected lateinit var propertyData: PropertyData
    /** Received class name.  */
    protected lateinit var receivedClassName: String
    /** True if result sent.  */
    private var resultSent: Boolean = false



    @SuppressLint("NewApi")
    override fun onHandleIntent(intent: Intent?) {
        Logger.d("onHandleIntent")

        var notificationManager : NotificationManager? = null
        try {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, getString(R.string.app_name), NotificationManager.IMPORTANCE_LOW)
                notificationManager.createNotificationChannel(channel)
                val builder = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText("")
                        .setSmallIcon(R.drawable.ic_launcher)
                startForeground(NOTIFICATION_ID, builder.build())
            }

            if (intent == null)
                return

            resultSent = false
            context = applicationContext
            prefs = Prefs(this)
            pluginIntent = MediaPluginIntent(intent)
            propertyData = pluginIntent.propertyData ?: PropertyData()
            receivedClassName = pluginIntent.getStringExtra(RECEIVED_CLASS_NAME)

        } catch (e: Exception) {
            Logger.e(e)
        } finally {
            if (notificationManager != null) {
                notificationManager.deleteNotificationChannel(NOTIFICATION_CHANNEL_ID)
                notificationManager.cancel(NOTIFICATION_ID)
                stopForeground(true)
            }
        }
    }
//    override fun onHandleIntent(intent: Intent?) {
//        Logger.d("onHandleIntent: " + this.javaClass.simpleName)
//
//        // create notification
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = getString(R.string.app_name)// The user-visible name of the channel.
//            val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_MIN)
//            channel.enableLights(false)
//            channel.enableVibration(false)
//            channel.setBypassDnd(false)
//            channel.setShowBadge(false)
//            channel.setSound(null, null)
//            channel.lockscreenVisibility = Notification.VISIBILITY_SECRET
//
//            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//
//            val notification = Notification.Builder(this, CHANNEL_ID)
//                    .setSmallIcon(R.drawable.ic_launcher)
//                    .setCategory(Notification.CATEGORY_PROGRESS)
//                    .setChannelId(CHANNEL_ID)
//                    .build()
//            notificationManager.notify(SERVICE_ID, notification)
//            startForeground(SERVICE_ID, notification)
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("onDestroy" + this.javaClass.simpleName)
        stopForeground(true)
        sendResult(null)
    }


//    protected open fun process(intent: Intent) {
//        pluginIntent = MediaPluginIntent(intent)
//        propertyData = pluginIntent.propertyData
//        receivedClassName = pluginIntent.getStringExtra(RECEIVED_CLASS_NAME)
//        resultSent = false
//    }

    /**
     * Send result
     * @param resultProperty A result property data.
     * @param resultExtra A result extra data.
     */
    protected fun sendResult(resultProperty: PropertyData?, resultExtra: ExtraData? = null) {
        if (!resultSent && (this is PluginGetLyricsService)) {
            AppUtils.sendResult(this, pluginIntent, resultProperty, resultExtra)
            resultSent = true
        }
    }

    companion object {
        /** Notification ID */
        private const val NOTIFICATION_ID = 1
        /** Notification Channel ID */
        private const val NOTIFICATION_CHANNEL_ID = "Notification"

        /** Received receiver class name.  */
        const val RECEIVED_CLASS_NAME = "RECEIVED_CLASS_NAME"
    }


}
