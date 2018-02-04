package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.os.Bundle
import android.preference.PreferenceActivity
import android.view.MenuItem
import com.wa2c.android.medoly.plugin.action.lrclyrics.R


/**
 * Settings activity
 */
class SettingsActivity : PreferenceActivity() {

    /**
     * onCreate event.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)
        actionBar.setTitle(R.string.title_activity_settings)
    }

    /**
     * onOptionsItemSelected event.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
