package com.wa2c.android.medoly.plugin.action.viewlyrics.util;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.DefaultStringSet;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

import java.util.List;
import java.util.Set;

/**
 * Shared preferences.
 */
@SharedPref
public interface LanguagePrefs {

    @DefaultStringSet({})
    Set<String> language_names();

    @DefaultStringSet({})
    Set<String> language_profiles();

}
