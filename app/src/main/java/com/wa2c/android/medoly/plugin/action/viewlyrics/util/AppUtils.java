package com.wa2c.android.medoly.plugin.action.viewlyrics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.google.gson.Gson;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;

import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.Arrays;


/**
 * アプリユーティリティ。
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


    // Language

    /** Language names. */
    private static String[] languageNames;
    /** Language profiles. */
    private static String[] languageProfiles;

    /**
     * Get language names.
     * @param context context.
     * @return language names.
     */
    public static synchronized String[] getLanguageNames(Context context) {
        if (languageNames == null)
            languageNames = context.getResources().getStringArray(R.array.language_names);
        return languageNames;
    }

    /**
     * Get language profiles.
     * @param context context.
     * @return language profiles.
     */
    public static synchronized  String[] getLanguageProfiels(Context context) {
        if (languageProfiles == null)
            languageProfiles = context.getResources().getStringArray(R.array.language_profiles);
        return languageProfiles;
    }

    /**
     * Get language detector.
     * @param context context.
     * @return Language detector.
     */
    public static Detector createDetector(Context context) throws LangDetectException {
        // Language profile
        if (DetectorFactory.getLangList() == null || DetectorFactory.getLangList().size() == 0) {
            // initialize
            DetectorFactory.clear();
            DetectorFactory.loadProfile(Arrays.asList(getLanguageProfiels(context)));
        }
        return DetectorFactory.create();
    }



    /**
     * 引数で与えられた最初の空またはnull以外の値を返す.
     * @param texts テキスト.
     * @return 最初のnull以外のオブジェクト. 対象の値が無い場合は空文字.
     */
    public static CharSequence coalesce(CharSequence... texts) {
        if (texts == null)
            return "";
        for (CharSequence text : texts) {
            if (!TextUtils.isEmpty(text))
                return text;
        }
        return "";
    }

    /**
     * 文字列の比較. nullは最大.
     * @param text1 文字列1.
     * @param text2 文字列2.
     * @return 比較結果.
     */
    public static int compare(CharSequence text1, CharSequence text2) {
        if (text1 == null && text2 == null)
            return 0;
        else if (text1 == null)
            return 1;
        else if (text2 == null)
            return -1;
        else
            return text1.toString().compareTo(text2.toString());
    }


//
//    /**
//     * 歌詞を調整する。
//     * @param text 歌詞テキスト。
//     * @return 調整後の歌詞テキスト。
//     */
//    public static String adjustLyrics(String text) {
//        if (TextUtils.isEmpty(text))
//            return null;
//
//        // タグ除去
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString();
//        } else {
//            text = Html.fromHtml(text).toString();
//        }
//
//        // トリミング
//        text = trimLines(text);
//
//        return text;
//    }

    /**
     * 全角を含めてトリミング。
     * @param text 元テキスト。
     * @return トリミングテキスト。
     */
    public static String trimLines(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        return text.replaceAll("(?m)^[\\t 　]*", "").replaceAll("(?m)[\\t 　]*$", "").trim();
    }



    /**
     * 比較向けにテキストをノーマライズ。
     * @param text テキスト。
     * @return 変換後テキスト。
     */
    public static String normalizeText(String text) {
        if (TextUtils.isEmpty(text))
            return "";

        // 正規化
        String output = trimLines(removeParentheses(Normalizer.normalize(text, Normalizer.Form.NFKC)).toLowerCase());
        // 特殊文字正規化
        return output
                .replace("゠", "=")
                .replace("(“|”)", "\"")
                .replace("(‘|’)", "\'");
    }

    /**
     * 括弧で括られた文字等（補助文字）を取り除く
     * @param text テキスト。
     * @return 括弧を取り除いたテキスト。
     */
    private static String removeParentheses(String text) {
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
                .replaceAll("(^[^\\-]+)-.*?-", "$1")
                .replaceAll("(^[^\\－]+)－.*?－", "$1")
                .replaceAll(" (~|～|〜|〰).*", "");

    }


    /**
     * 2つのテキストを比較して、ほぼ同じ場合はtrue。
     * @param text1 比較テキスト1。
     * @param text2 比較テキスト2。
     * @return ほぼ一致する場合はtrue。
     */
    public static boolean similarText(String text1, String text2) {
        if (TextUtils.isEmpty(text1) || TextUtils.isEmpty(text2))
            return false;

        String it = removeWhitespace(normalizeText(text1), false);
        String ot = removeWhitespace(normalizeText(text2), false);
        return it.equals(ot);
    }

    /**
     * 空白を置換える
     * @param text テキスト。
     * @param insertSpace スペースに置換える場合はtrue。
     * @return 変換後テキスト。
     */
    private static String removeWhitespace(String text, boolean insertSpace) {
        if (TextUtils.isEmpty(text))
            return "";

        return text.replaceAll("(\\s|　)", insertSpace ? " " : "");
    }

}
