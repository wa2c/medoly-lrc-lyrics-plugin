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



    @DefaultBoolean(true)
    boolean pref_use_cache();

    @DefaultBoolean(true)
    boolean pref_cache_result();

    @DefaultBoolean(true)
    boolean pref_cache_non_result();

    String pref_search_first_language();

    String pref_search_second_language();

    String pref_search_third_language();

    boolean pref_search_non_preferred_language();

    int pref_search_language_threshold();
}
