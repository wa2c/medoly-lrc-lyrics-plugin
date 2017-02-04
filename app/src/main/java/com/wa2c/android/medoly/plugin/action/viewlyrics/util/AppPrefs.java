package com.wa2c.android.medoly.plugin.action.viewlyrics.util;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Shared preferences.
 */
@SharedPref
public interface AppPrefs {
    @DefaultString("")
    String test();

    @DefaultString("")
    String test2();
}
