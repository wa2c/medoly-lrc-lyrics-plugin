package com.wa2c.android.medoly.plugin.action.lrclyrics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.google.gson.Gson;
import com.wa2c.android.medoly.library.PluginOperationCategory;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;

import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * App utilities.
 */
public class AppUtils {

    /**
     * Show message.
     * @param context context.
     * @param text message.
     */
    public static void showToast(Context context, String text) {
        ToastReceiver.showToast(context, text);
    }

    /**
     * Show message.
     * @param context context
     * @param stringId resource id.
     */
    public static void showToast(Context context, int stringId) {
        ToastReceiver.showToast(context, stringId);
    }

    /**
     * Save object to shared preference.
     * @param context context
     * @param prefKey preference key.
     * @param saveObject save object.
     * @return succeeded / failed
     */
    public static boolean saveObject(Context context, String prefKey,  Object saveObject) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(saveObject);

            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            pref.edit().putString(prefKey, json).apply();
            return true;
        } catch (Exception e) {
            Logger.e(e);
            return false;
        }
    }

    /**
     * Load object from shared preference.
     * @param context Context.
     * @param prefKey Preference key.
     * @param clazz Object class.
     * @return Loaded object. null as failed.
     */
    public static <T> T loadObject(Context context, String prefKey, Class<T> clazz) {
        try {
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            String json = pref.getString(prefKey, "");

            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            Logger.e(e);
            return null;
        }
    }

    /**
     * Load object from shared preference.
     * @param context Context.
     * @param prefKey Preference key.
     * @param type Object type.
     * @return Loaded object. null as failed.
     */
    public static <T> T loadObject(Context context, String prefKey, Type type) {
        try {
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            String json = pref.getString(prefKey, "");

            Gson gson = new Gson();

            return gson.fromJson(json, type);
        } catch (Exception e) {
            Logger.e(e);
            return null;
        }
    }

    /**
     * Version up.
     * @param context Context.
     */
    public static void versionUp(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);

        final String pref_plugin_event = "pref_plugin_event";
        if (pref.contains(pref_plugin_event)) {
            int val = pref.getInt(pref_plugin_event, 0);
            if (val == 1)
                pref.edit().putString(context.getString(R.string.pref_event_get_lyrics), PluginOperationCategory.OPERATION_MEDIA_OPEN.name()).apply();
            else if (val == 2)
                pref.edit().putString(context.getString(R.string.pref_event_get_lyrics), PluginOperationCategory.OPERATION_PLAY_START.name()).apply();
            pref.edit().remove(pref_plugin_event).apply();
        }

    }



    /**
     * Get first non-null object.
     * @param objects Objects.
     * @return First non-null object. null as all null.
     */
    public static <T> T coalesce(T... objects) {
        if (objects == null)
            return null;
        for (T obj : objects) {
            if (obj != null)
                return obj;
        }
        return null;
    }

    /**
     * Get first non-null text.
     * @param texts Texts.
     * @return First non-null object. empty text as all null.
     */
    public static String coalesce(String... texts) {
        if (texts == null)
            return "";
        for (String text : texts) {
            if (!TextUtils.isEmpty(text))
                return text;
        }
        return "";
    }



    /**
     * Trim spaces including full-width characters.
     * @param text Text.
     * @return Trimmed text.
     */
    public static String trimLines(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        return text.replaceAll("(?m)^[\\t 　]*", "").replaceAll("(?m)[\\t 　]*$", "").trim();
    }

    /**
     * Normalize text.
     * @param text text.
     * @return Normalized text.
     */
    public static String normalizeText(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        // normalize
        String output = trimLines(Normalizer.normalize(text, Normalizer.Form.NFKC)).toLowerCase();
        // change special characters
        return output
                .replace("゠", "=")
                .replace("(“|”)", "\"")
                .replace("(‘|’)", "\'");
    }

    /**
     * Remove parentheses.
     * @param text text.
     * @return removed text.
     */
    public static String removeParentheses(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        return text
                .replaceAll("(^[^\\(]+)\\(.*?\\)", "$1")
                .replaceAll("(^[^\\[]+)\\[.*?\\]", "$1")
                .replaceAll("(^[^\\{]+)\\{.*?\\}", "$1")
                .replaceAll("(^[^\\<]+)\\<.*?\\>", "$1")
                .replaceAll("(^[^\\（]+)\\（.*?\\）", "$1")
                .replaceAll("(^[^\\［]+)\\［.*?\\］", "$1")
                .replaceAll("(^[^\\｛]+)\\｛.*?\\｝", "$1")
                .replaceAll("(^[^\\＜]+)\\＜.*?\\＞", "$1")
                .replaceAll("(^[^\\【]+)\\【.*?\\】", "$1")
                .replaceAll("(^[^\\〔]+)\\〔.*?\\〕", "$1")
                .replaceAll("(^[^\\〈]+)\\〈.*?\\〉", "$1")
                .replaceAll("(^[^\\《]+)\\《.*?\\》", "$1")
                .replaceAll("(^[^\\「]+)\\「.*?\\」", "$1")
                .replaceAll("(^[^\\『]+)\\『.*?\\』", "$1")
                .replaceAll("(^[^\\〖]+)\\〖.*?\\〗", "$1")
                ;
    }

    /**
     * Remove text after dash characters.
     * @param text text.
     * @return removed text.
     */
    public static String removeDash(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        return text
                .replaceAll("\\s+(-|－|―|ー|ｰ|~|～|〜|〰|=|＝).*", "");
    }

    /**
     * Remove attached info.
     * @param text text.
     * @return removed text.
     */
    public static String removeTextInfo(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        return text
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?off vocal.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?no vocal.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?less vocal.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?without.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?w/o.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?backtrack.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?backing track.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?karaoke.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?カラオケ.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?からおけ.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?歌無.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?vocal only.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?instrumental.*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?inst\\..*", "")
                .replaceAll("(?i)[\\(\\<\\[\\{\\s]?インスト.*", "")
                ;
    }

}
