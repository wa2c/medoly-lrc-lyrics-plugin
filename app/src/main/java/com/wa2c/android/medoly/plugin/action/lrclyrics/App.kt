package com.wa2c.android.medoly.plugin.action.lrclyrics

import android.app.Application
import timber.log.Timber


/**
 * App
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Migrator(this).versionUp()
    }
}
