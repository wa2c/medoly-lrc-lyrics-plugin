package com.wa2c.android.medoly.plugin.action.lrclyrics.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;

import com.cybozu.labs.langdetect.DetectorFactoryUtil;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.dialog.AboutDialogFragment;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.lrclyrics.view.SeekBarPreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;


/**
 * Settings activity
 */
public class SettingsActivity extends PreferenceActivity {

    /**
     * onCreate event.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    /**
     * onOptionsItemSelected event.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * Settings fragment.
     */
    public static class SettingsFragment extends PreferenceFragment {

        /** Summary length map. */
        private static final HashMap<Preference, Integer> summaryLengthMap = new LinkedHashMap<>();

        /**
         * onCreate event.
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_settings);

              // language priority
            {
                String[] languages = DetectorFactoryUtil.getLanguageNames();
                List<Pair<String, String>> languageList = new ArrayList<>(languages.length);
                for (int i = 0; i < languages.length; i++) {
                    String[] langs = languages[i].split("-");
                    if (langs.length == 1)
                        languageList.add(new Pair<>(languages[i], (new Locale(langs[0])).getDisplayName()));
                    else if (langs.length == 2)
                        languageList.add(new Pair<>(languages[i], (new Locale(langs[0], langs[1])).getDisplayName()));
                    else if (langs.length >= 3)
                        languageList.add(new Pair<>(languages[i], (new Locale(langs[0], langs[1], langs[2])).getDisplayName()));
                }

                // sort
                Collections.sort(languageList, new Comparator<Pair<String, String>>() {
                    @Override
                    public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                        return o1.second.compareTo(o2.second);
                    }
                });

                List<String> sortedLanguageList = new ArrayList<>(languageList.size());
                List<String> sortedLanguageLabelList = new ArrayList<>(languageList.size());
                for (int i = 0; i < languageList.size(); i++) {
                    sortedLanguageList.add(languageList.get(i).first);
                    sortedLanguageLabelList.add(languageList.get(i).second);
                }

                // default value
                sortedLanguageList.add(0, "");
                sortedLanguageLabelList.add(0, getString(R.string.settings_not_set));

                // first language
                ListPreference p1 = (ListPreference) findPreference(getString(R.string.pref_search_first_language));
                p1.setEntryValues(sortedLanguageList.toArray(new String[sortedLanguageList.size()]));
                p1.setEntries(sortedLanguageLabelList.toArray(new String[sortedLanguageLabelList.size()]));
                // second language
                ListPreference p2 = (ListPreference) findPreference(getString(R.string.pref_search_second_language));
                p2.setEntryValues(sortedLanguageList.toArray(new String[sortedLanguageList.size()]));
                p2.setEntries(sortedLanguageLabelList.toArray(new String[sortedLanguageLabelList.size()]));
                // third language
                ListPreference p3 = (ListPreference) findPreference(getString(R.string.pref_search_third_language));
                p3.setEntryValues(sortedLanguageList.toArray(new String[sortedLanguageList.size()]));
                p3.setEntries(sortedLanguageLabelList.toArray(new String[sortedLanguageLabelList.size()]));
                // NOTE: set default value on xml file.

                // initialize
                findPreference(getString(R.string.pref_search_second_language)).setEnabled(!TextUtils.isEmpty(p1.getValue()));
                findPreference(getString(R.string.pref_search_third_language)).setEnabled(!TextUtils.isEmpty(p1.getValue()) && !TextUtils.isEmpty(p2.getValue()));
            }

            // App info
            findPreference(getString(R.string.pref_application_details)).setOnPreferenceClickListener(applicationDetailsPreferenceClickListener);
            // About
            findPreference(getString(R.string.pref_about)).setOnPreferenceClickListener(aboutPreferenceClickListener);

            initSummary(getPreferenceScreen());
        }

        /**
         * onResume event.
         */
        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(listener);
        }

        /**
         * onPause event.
         */
        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(listener);
        }



        /**
         * App info.
         */
        private Preference.OnPreferenceClickListener applicationDetailsPreferenceClickListener = new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                startActivity(intent);
                return true;
            }
        };

        /**
         * About.
         */
        private Preference.OnPreferenceClickListener aboutPreferenceClickListener = new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                AboutDialogFragment.newInstance().show(getActivity());
                return true;
            }
        };

        /**
         * Initialize summary.
         * @param p target item.
         */
        private void initSummary(Preference p) {
            if (p == null) return;

            // get summary length
            CharSequence summary = p.getSummary();
            if (summary != null && summary.length() > 0) {
                if (summary.toString().lastIndexOf("\n") != 0) p.setSummary(summary + "\n"); // add break
                summaryLengthMap.put(p, p.getSummary().length());
            } else {
                summaryLengthMap.put(p, 0);
            }

            // update summary
            if (p instanceof PreferenceCategory) {
                PreferenceCategory pCat = (PreferenceCategory) p;
                for (int i = 0; i < pCat.getPreferenceCount(); i++) {
                    initSummary(pCat.getPreference(i));
                }
            } else if (p instanceof PreferenceScreen) {
                PreferenceScreen ps = (PreferenceScreen) p;
                for (int i = 0; i < ps.getPreferenceCount(); i++) {
                    initSummary(ps.getPreference(i));
                }
            } else {
                updatePrefSummary(p);
            }
        }

        /**
         * Update summary.
         * @param p target preference.
         */
        private void updatePrefSummary(Preference p) {
            if (p == null) return;

            String key = p.getKey();
            CharSequence summary = p.getSummary();
            if (TextUtils.isEmpty(key)) return;
            if (TextUtils.isEmpty(summary)) summary = "";

            // for instance type
            if (p instanceof ListPreference) {
                // ListPreference
                ListPreference pref = (ListPreference) p;
                pref.setValue(p.getSharedPreferences().getString(pref.getKey(), ""));
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, pref.getEntry()));
            } else if (p instanceof MultiSelectListPreference) {
                // MultiSelectListPreference
                MultiSelectListPreference pref = (MultiSelectListPreference) p;
                Set<String> stringSet = pref.getSharedPreferences().getStringSet(pref.getKey(), null);
                String text = "";
                if (stringSet != null && stringSet.size() > 0) {
                    pref.setValues(stringSet); // update value once
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < pref.getEntries().length; i++) {
                        if (stringSet.contains(pref.getEntryValues()[i])) {
                            builder.append(pref.getEntries()[i]).append(",");
                        }
                    }
                    if (builder.length() > 0) {
                        text = builder.substring(0, builder.length() - 1); // remove end comma
                    }
                }
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, text));
            } else if (p instanceof EditTextPreference) {
                // EditTextPreference
                EditTextPreference pref = (EditTextPreference) p;
                String text = p.getSharedPreferences().getString(pref.getKey(), "");

                // adjust numeric values
                int inputType = pref.getEditText().getInputType();
                try {
                    if ( (inputType & InputType.TYPE_CLASS_NUMBER) > 0) {
                        if ((inputType & InputType.TYPE_NUMBER_FLAG_DECIMAL) > 0) {
                            // float
                            float val = Float.valueOf(text);
                            if ((inputType & InputType.TYPE_NUMBER_FLAG_SIGNED) == 0 && val < 0) {
                                val = 0;
                            }
                            text = String.valueOf(val);
                        } else {
                            // integer
                            int val = Integer.valueOf(text);
                            if ((inputType & InputType.TYPE_NUMBER_FLAG_SIGNED) == 0 && val < 0) {
                                val = 0;
                            }
                            text = String.valueOf(val);
                        }
                    }
                } catch (NumberFormatException e) {
                    text = "0";
                }
                pref.setText(text); // update once
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, text));
            } else if (p instanceof SeekBarPreference) {
                // SeekBarPreference
                SeekBarPreference pref = (SeekBarPreference) p;
                //pref.setProgress(pref.getProgress());
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, String.valueOf(pref.getProgress())));
            }

            // individual
            if (key.equals(getString(R.string.pref_search_first_language)) ||
                    key.equals(getString(R.string.pref_search_second_language)) ||
                    key.equals(getString(R.string.pref_search_third_language))) {
                // first language
                Preference p1 = findPreference(getString(R.string.pref_search_first_language));
                String lang1 = p.getSharedPreferences().getString(p1.getKey(), "");
                // second language
                Preference p2 = findPreference(getString(R.string.pref_search_second_language));
                String lang2 = p.getSharedPreferences().getString(p2.getKey(), "");
                p2.setEnabled(!TextUtils.isEmpty(lang1));
                // third language
                Preference p3 = findPreference(getString(R.string.pref_search_third_language));
                p3.setEnabled(!TextUtils.isEmpty(lang2));
            }
        }

        /**
         * On change settings.
         */
        private SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                updatePrefSummary(findPreference(key));
            }
        };

    }

}
