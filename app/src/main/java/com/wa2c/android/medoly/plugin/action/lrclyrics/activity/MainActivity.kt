package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.wa2c.android.medoly.library.MedolyEnvironment
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main activity.
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)

        // Search
        launchSearchButton.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        // Cache
        launchCacheButton.setOnClickListener {
            startActivity(Intent(this, CacheActivity::class.java))
        }

        // Settings
        launchSettingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        // Launch Medoly
        launchMedolyButton.setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage(MedolyEnvironment.MEDOLY_PACKAGE)
            if (intent == null) {
                AppUtils.showToast(this, R.string.message_no_medoly)
                return@setOnClickListener
            }
            startActivity(intent)
        }
    }

}
