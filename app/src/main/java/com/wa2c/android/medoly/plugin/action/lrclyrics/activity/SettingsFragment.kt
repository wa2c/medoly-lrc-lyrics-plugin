package com.wa2c.android.medoly.plugin.action.lrclyrics.activity

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.preference.*
import android.provider.Settings
import android.text.InputType
import android.util.Pair
import com.cybozu.labs.langdetect.DetectorFactoryUtil
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.AboutDialogFragment
import java.util.*


/**
 * Settings fragment
 */
class SettingsFragment : PreferenceFragment() {

    companion object {
        /** Summary length map.  */
        private val summaryLengthMap = LinkedHashMap<Preference, Int>()
    }



    /**
     * App info.
     */
    private val applicationDetailsPreferenceClickListener = Preference.OnPreferenceClickListener {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.data = Uri.parse("package:" + activity.packageName)
        startActivity(intent)
        true
    }

    /**
     * About.
     */
    private val aboutPreferenceClickListener = Preference.OnPreferenceClickListener {
        AboutDialogFragment.newInstance().show(activity)
        true
    }

    /**
     * On change settings.
     */
    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key -> updatePrefSummary(findPreference(key)) }

    /**
     * onCreate event.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref_settings)

        // language priority
        run {
            val languages = DetectorFactoryUtil.languageNames
            val languageList = ArrayList<Pair<String, String>>(languages.size)
            for (i in languages.indices) {
                val langs = languages[i].split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (langs.size == 1)
                    languageList.add(Pair(languages[i], Locale(langs[0]).displayName))
                else if (langs.size == 2)
                    languageList.add(Pair(languages[i], Locale(langs[0], langs[1]).displayName))
                else if (langs.size >= 3)
                    languageList.add(Pair(languages[i], Locale(langs[0], langs[1], langs[2]).displayName))
            }

            // sort
            Collections.sort(languageList) { o1, o2 -> o1.second.compareTo(o2.second) }

            val sortedLanguageList = ArrayList<String>(languageList.size)
            val sortedLanguageLabelList = ArrayList<String>(languageList.size)
            for (i in languageList.indices) {
                sortedLanguageList.add(languageList[i].first)
                sortedLanguageLabelList.add(languageList[i].second)
            }

            // default value
            sortedLanguageList.add(0, "")
            sortedLanguageLabelList.add(0, getString(R.string.settings_not_set))

            // first language
            val p1 = findPreference(getString(R.string.pref_search_first_language)) as ListPreference
            p1.entryValues = sortedLanguageList.toTypedArray()
            p1.entries = sortedLanguageLabelList.toTypedArray()
            // second language
            val p2 = findPreference(getString(R.string.pref_search_second_language)) as ListPreference
            p2.entryValues = sortedLanguageList.toTypedArray()
            p2.entries = sortedLanguageLabelList.toTypedArray()
            // third language
            val p3 = findPreference(getString(R.string.pref_search_third_language)) as ListPreference
            p3.entryValues = sortedLanguageList.toTypedArray()
            p3.entries = sortedLanguageLabelList.toTypedArray()
            // NOTE: set default value on xml file.

            // initialize
            findPreference(getString(R.string.pref_search_second_language)).isEnabled = !p1.value.isNullOrEmpty()
            findPreference(getString(R.string.pref_search_third_language)).isEnabled = p2.isEnabled && !p2.value.isNullOrEmpty()
        }

        // App info
        findPreference(getString(R.string.pref_application_details)).onPreferenceClickListener = applicationDetailsPreferenceClickListener
        // About
        findPreference(getString(R.string.pref_about)).onPreferenceClickListener = aboutPreferenceClickListener

        initSummary(preferenceScreen)
    }

    /**
     * onResume event.
     */
    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    /**
     * onPause event.
     */
    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    /**
     * Initialize summary.
     * @param p target item.
     */
    private fun initSummary(p: Preference) {
        // get summary length
        val summary = p.summary
        if (!summary.isNullOrEmpty()) {
            if (summary.toString().lastIndexOf("\n") != 0) p.summary = summary.toString() + "\n" // add break
            summaryLengthMap[p] = p.summary.length
        } else {
            summaryLengthMap[p] = 0
        }

        // update summary
        when (p) {
            is PreferenceCategory -> {
                val pCat = p as PreferenceCategory?
                for (i in 0 until pCat!!.preferenceCount) {
                    initSummary(pCat.getPreference(i))
                }
            }
            is PreferenceScreen -> {
                val ps = p as PreferenceScreen?
                for (i in 0 until ps!!.preferenceCount) {
                    initSummary(ps.getPreference(i))
                }
            }
            else -> updatePrefSummary(p)
        }
    }

    /**
     * Update summary.
     * @param p target preference.
     */
    private fun updatePrefSummary(p: Preference) {
        val key = p.key
        var summary = p.summary
        if (key.isNullOrEmpty())
            return
        if (summary.isNullOrEmpty())
            summary = ""

        val labelSize = summaryLengthMap[p] ?: 0

        // for instance type
        when (p) {
            is ListPreference -> {
                // ListPreference
                p.value = p.sharedPreferences.getString(p.key, "")
                p.setSummary(summary.subSequence(0, labelSize).toString() + getString(R.string.settings_summary_current_value, p.entry))
            }
            is MultiSelectListPreference -> {
                // MultiSelectListPreference
                val stringSet = p.sharedPreferences.getStringSet(p.key, null)
                var text = ""
                if (stringSet != null && stringSet.size > 0) {
                    p.values = stringSet // update value once
                    val builder = StringBuilder()
                    (0 until p.entries.size)
                            .filter { stringSet.contains(p.entryValues[it]) }
                            .forEach { builder.append(p.entries[it]).append(",") }
                    if (builder.isNotEmpty()) {
                        text = builder.substring(0, builder.length - 1) // remove end comma
                    }
                }
                p.setSummary(summary.subSequence(0, labelSize).toString() + getString(R.string.settings_summary_current_value, text))
            }
            is EditTextPreference -> {
                // EditTextPreference
                var text = p.sharedPreferences.getString(p.key, "")

                // adjust numeric values
                val inputType = p.editText.inputType
                try {
                    if (inputType and InputType.TYPE_CLASS_NUMBER > 0) {
                        if (inputType and InputType.TYPE_NUMBER_FLAG_DECIMAL > 0) {
                            // float
                            var `val` = java.lang.Float.valueOf(text)!!
                            if (inputType and InputType.TYPE_NUMBER_FLAG_SIGNED == 0 && `val` < 0) {
                                `val` = 0f
                            }
                            text = `val`.toString()
                        } else {
                            // integer
                            var `val` = Integer.valueOf(text)!!
                            if (inputType and InputType.TYPE_NUMBER_FLAG_SIGNED == 0 && `val` < 0) {
                                `val` = 0
                            }
                            text = `val`.toString()
                        }
                    }
                } catch (e: NumberFormatException) {
                    text = "0"
                }

                p.text = text // update once
                p.setSummary(summary.subSequence(0, labelSize).toString() + getString(R.string.settings_summary_current_value, text))
            }
        }

        // individual
        if (key == getString(R.string.pref_search_first_language) ||
            key == getString(R.string.pref_search_second_language) ||
            key == getString(R.string.pref_search_third_language)) {
            // first language
            val p1 = findPreference(getString(R.string.pref_search_first_language))
            val lang1 = p.sharedPreferences.getString(p1.key, "")
            // second language
            val p2 = findPreference(getString(R.string.pref_search_second_language))
            val lang2 = p.sharedPreferences.getString(p2.key, "")
            p2.isEnabled = !lang1.isNullOrEmpty()
            // third language
            val p3 = findPreference(getString(R.string.pref_search_third_language))
            p3.isEnabled = !lang2.isNullOrEmpty()
        }
    }

}
