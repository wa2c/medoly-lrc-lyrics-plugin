package com.wa2c.android.medoly.plugin.action.viewlyrics.util;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Shared preferences.
 */
@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface AppPrefs {
    @DefaultInt(0)
    int prefPluginEvent();

    boolean pref_use_cache();

    boolean pref_cache_event();

    boolean pref_cache_event_non_result();

    String pref_search_first_language();

    String pref_search_second_language();

    String pref_search_third_language();
}
