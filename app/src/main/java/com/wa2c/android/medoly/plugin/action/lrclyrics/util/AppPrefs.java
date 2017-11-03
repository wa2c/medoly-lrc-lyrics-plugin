package com.wa2c.android.medoly.plugin.action.lrclyrics.util;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Shared preferences.
 */
@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface AppPrefs {
//    @DefaultInt(0)
//    int pref_plugin_event();

    @DefaultString("")
    String pref_event_get_lyrics();

    @DefaultBoolean(true)
    boolean pref_use_cache();

    @DefaultBoolean(true)
    boolean pref_cache_result();

    @DefaultBoolean(true)
    boolean pref_cache_non_result();

    @DefaultString("")
    String pref_search_first_language();

    @DefaultString("")
    String pref_search_second_language();

    @DefaultString("")
    String pref_search_third_language();

    @DefaultBoolean(true)
    boolean pref_search_non_preferred_language();

    @DefaultInt(50)
    int pref_search_language_threshold();

    @DefaultBoolean(false)
    boolean pref_success_message_show();

    @DefaultBoolean(false)
    boolean pref_failure_message_show();


}
