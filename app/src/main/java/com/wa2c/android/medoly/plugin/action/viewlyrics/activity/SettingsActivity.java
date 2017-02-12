package com.wa2c.android.medoly.plugin.action.viewlyrics.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
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
import android.support.v4.content.res.TypedArrayUtils;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wa2c.android.medoly.library.MediaProperty;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.AppUtils;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.Logger;
import com.wa2c.android.medoly.plugin.action.viewlyrics.util.SeekBarPreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
                String[] languagesTemp = AppUtils.getLanguageNames();
                String[] languages = new String[languagesTemp.length + 1];
                System.arraycopy(languagesTemp, 0, languages, 1, languagesTemp.length);
                String[] languageNames = new String[languages.length];
                // not set item
                languages[0] = "";
                languageNames[0] = getString(R.string.settings_not_set);
                for (int i = 1; i < languages.length; i++) {
                    String[] langs = languages[i].split("-");
                    if (langs.length == 1)
                        languageNames[i] = (new Locale(langs[0])).getDisplayName();
                    else if (langs.length == 2)
                        languageNames[i] = (new Locale(langs[0], langs[1])).getDisplayName();
                    else if (langs.length >= 3)
                        languageNames[i] = (new Locale(langs[0], langs[1], langs[2])).getDisplayName();
                }
                // first language
                ListPreference p1 = (ListPreference) findPreference(getString(R.string.pref_search_first_language));
                p1.setEntryValues(languages);
                p1.setEntries(languageNames);
                // second language
                ListPreference p2 = (ListPreference) findPreference(getString(R.string.pref_search_second_language));
                p2.setEntryValues(languages);
                p2.setEntries(languageNames);
                // third language
                ListPreference p3 = (ListPreference) findPreference(getString(R.string.pref_search_third_language));
                p3.setEntryValues(languages);
                p3.setEntries(languageNames);
                // NOTE: set default value on xml file.

                // initialize
                findPreference(getString(R.string.pref_search_second_language)).setEnabled(!TextUtils.isEmpty(p1.getValue()));
                findPreference(getString(R.string.pref_search_third_language)).setEnabled(!TextUtils.isEmpty(p1.getValue()) && !TextUtils.isEmpty(p2.getValue()));
            }

            // アプリ情報
            findPreference(getString(R.string.prefkey_application_details)).setOnPreferenceClickListener(applicationDetailsPreferenceClickListener);
            // About
            findPreference(getString(R.string.prefkey_about)).setOnPreferenceClickListener(aboutPreferenceClickListener);

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
                RelativeLayout layoutView = (RelativeLayout) View.inflate(getActivity(), R.layout.layout_about, null);

                // Version
                try {
                    PackageInfo packageInfo = getActivity().getPackageManager().getPackageInfo( getActivity().getPackageName(), PackageManager.GET_ACTIVITIES);
                    ((TextView)layoutView.findViewById(R.id.aboutAppVersionTextView)).setText("Ver. " + packageInfo.versionName);
                } catch (NameNotFoundException e) {
                    Logger.e(e);
                }

                // Developer
                ((TextView)layoutView.findViewById(R.id.aboutDeveloperNameTextView)).setText(getString(R.string.app_author));

                // Link
                Linkify.TransformFilter filter = new Linkify.TransformFilter() {
                    @Override
                    public String transformUrl(Matcher match, String url) {
                        return getString(R.string.app_market_web);
                    }
                };
                Linkify.addLinks(
                        (TextView)layoutView.findViewById(R.id.aboutGooglePlayTextView),
                        Pattern.compile("Google Play"),
                        getString(R.string.app_market_web),
                        null,
                        filter);

                // Contact
                ((TextView)layoutView.findViewById(R.id.aboutEmailTextView)).setText(getString(R.string.app_mail_name) + "@" + getString(R.string.app_mail_domain));

                // Library
                String[] libraryNames = getResources().getStringArray(R.array.about_library_names);
                String[] libraryUrls = getResources().getStringArray(R.array.about_library_urls);

                for (int i = 0; i < libraryNames.length; i++) {
                    TextView libTextView;
                    LinearLayout libraryLayout = (LinearLayout) layoutView.findViewById(R.id.abountLibraryLayout);
                    libTextView = new TextView(getActivity());
                    libTextView.setMovementMethod(LinkMovementMethod.getInstance());
//                    if (Build.VERSION.SDK_INT >= 24) {
//                        libTextView.setText(Html.fromHtml("<a href=\"" + libraryUrls[i] + "\">" +  libraryNames[i] + "</a>", Html.FROM_HTML_MODE_COMPACT));
//                    } else {
//                        libTextView.setText(Html.fromHtml("<a href=\"" + libraryUrls[i] + "\">" +  libraryNames[i] + "</a>"));
//                    }
                    libTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                    libraryLayout.setPadding(2, 2, 2, 2);
                    libraryLayout.addView(libTextView);
                }

                // ダイアログ作成
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.pref_title_about);
                builder.setView(layoutView);
                builder.setPositiveButton(android.R.string.ok, null);
                builder.create().show();

                return true;
            }
        };

        /**
         * Initialize summary.
         * @param p target item.
         */
        private void initSummary(Preference p) {
            if (p == null) return;

            // サマリの長さ取得
            CharSequence summary = p.getSummary();
            if (summary != null && summary.length() > 0) {
                if (summary.toString().lastIndexOf("\n") != 0) p.setSummary(summary + "\n"); // 改行追加
                summaryLengthMap.put(p, p.getSummary().length());
            } else {
                summaryLengthMap.put(p, 0);
            }

            // サマリ更新
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

            // 種別毎
            if (p instanceof ListPreference) {
                // ListPreference
                ListPreference pref = (ListPreference) p;
                pref.setValue(p.getSharedPreferences().getString(pref.getKey(), "")); // 一度値を更新
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, pref.getEntry()));
            } else if (p instanceof MultiSelectListPreference) {
                // MultiSelectListPreference
                MultiSelectListPreference pref = (MultiSelectListPreference) p;
                Set<String> stringSet = pref.getSharedPreferences().getStringSet(pref.getKey(), null);
                String text = "";
                if (stringSet != null && stringSet.size() > 0) {
                    pref.setValues(stringSet); // 一度値を更新
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < pref.getEntries().length; i++) {
                        if (stringSet.contains(pref.getEntryValues()[i])) {
                            builder.append(pref.getEntries()[i]).append(",");
                        }
                    }
                    if (builder.length() > 0) {
                        text = builder.substring(0, builder.length() - 1); // 末尾のカンマ削除
                    }
                }
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, text));
            } else if (p instanceof EditTextPreference) {
                // EditTextPreference
                EditTextPreference pref = (EditTextPreference) p;
                String text = p.getSharedPreferences().getString(pref.getKey(), ""); // 値が更新されない場合があるので、pref.getText() は使用しない

                // 数値型の補正
                int inputType = pref.getEditText().getInputType();
                try {
                    if ( (inputType & InputType.TYPE_CLASS_NUMBER) > 0) {
                        if ((inputType & InputType.TYPE_NUMBER_FLAG_DECIMAL) > 0) {
                            // 小数
                            float val = Float.valueOf(text);
                            if ((inputType & InputType.TYPE_NUMBER_FLAG_SIGNED) == 0 && val < 0) {
                                val = 0;
                            }
                            text = String.valueOf(val);
                        } else {
                            // 整数
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
                pref.setText(text); // 一度値を更新
                p.setSummary(summary.subSequence(0, summaryLengthMap.get(p)) + getString(R.string.settings_summary_current_value, text));
            } else if (p instanceof SeekBarPreference) {
                // SeekBarPreference
                SeekBarPreference pref = (SeekBarPreference) p;
                //pref.setProgress(pref.getProgress()); // 一度値を更新
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
                // サマリ更新
                updatePrefSummary(findPreference(key));
            }
        };

    }

}
