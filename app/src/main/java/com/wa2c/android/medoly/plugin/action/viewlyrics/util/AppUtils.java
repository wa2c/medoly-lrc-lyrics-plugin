package com.wa2c.android.medoly.plugin.action.viewlyrics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.Language;
import com.google.gson.Gson;
import com.wa2c.android.medoly.plugin.action.viewlyrics.R;

import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


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

    private static final Map<String, Integer> languageProfileMap = new TreeMap<String, Integer>() {
        {
            put("af"    ,  R.string.language_profile_af    );
            put("ar"    ,  R.string.language_profile_ar    );
            put("bg"    ,  R.string.language_profile_bg    );
            put("bn"    ,  R.string.language_profile_bn    );
            put("cs"    ,  R.string.language_profile_cs    );
            put("da"    ,  R.string.language_profile_da    );
            put("de"    ,  R.string.language_profile_de    );
            put("el"    ,  R.string.language_profile_el    );
            put("en"    ,  R.string.language_profile_en    );
            put("es"    ,  R.string.language_profile_es    );
            put("et"    ,  R.string.language_profile_et    );
            put("fa"    ,  R.string.language_profile_fa    );
            put("fi"    ,  R.string.language_profile_fi    );
            put("fr"    ,  R.string.language_profile_fr    );
            put("gu"    ,  R.string.language_profile_gu    );
            put("he"    ,  R.string.language_profile_he    );
            put("hi"    ,  R.string.language_profile_hi    );
            put("hr"    ,  R.string.language_profile_hr    );
            put("hu"    ,  R.string.language_profile_hu    );
            put("id"    ,  R.string.language_profile_id    );
            put("it"    ,  R.string.language_profile_it    );
            put("ja"    ,  R.string.language_profile_ja    );
            put("kn"    ,  R.string.language_profile_kn    );
            put("ko"    ,  R.string.language_profile_ko    );
            put("lt"    ,  R.string.language_profile_lt    );
            put("lv"    ,  R.string.language_profile_lv    );
            put("mk"    ,  R.string.language_profile_mk    );
            put("ml"    ,  R.string.language_profile_ml    );
            put("mr"    ,  R.string.language_profile_mr    );
            put("ne"    ,  R.string.language_profile_ne    );
            put("nl"    ,  R.string.language_profile_nl    );
            put("no"    ,  R.string.language_profile_no    );
            put("pa"    ,  R.string.language_profile_pa    );
            put("pl"    ,  R.string.language_profile_pl    );
            put("pt"    ,  R.string.language_profile_pt    );
            put("ro"    ,  R.string.language_profile_ro    );
            put("ru"    ,  R.string.language_profile_ru    );
            put("sk"    ,  R.string.language_profile_sk    );
            put("sl"    ,  R.string.language_profile_sl    );
            put("so"    ,  R.string.language_profile_so    );
            put("sq"    ,  R.string.language_profile_sq    );
            put("sv"    ,  R.string.language_profile_sv    );
            put("sw"    ,  R.string.language_profile_sw    );
            put("ta"    ,  R.string.language_profile_ta    );
            put("te"    ,  R.string.language_profile_te    );
            put("th"    ,  R.string.language_profile_th    );
            put("tl"    ,  R.string.language_profile_tl    );
            put("tr"    ,  R.string.language_profile_tr    );
            put("uk"    ,  R.string.language_profile_uk    );
            put("ur"    ,  R.string.language_profile_ur    );
            put("vi"    ,  R.string.language_profile_vi    );
            put("zh-cn" ,  R.string.language_profile_zh_cn );
            put("zh-tw" ,  R.string.language_profile_zh_tw );
        }
    };


    /** Language profiles. */
    private static String[] languageProfiles;

    /**
     * Get language names.
     * @return language names.
     */
    public static String[] getLanguageNames() {
        return languageProfileMap.keySet().toArray(new String[languageProfileMap.size()]);
    }

    /**
     * Get language profiles.
     * @param context context.
     * @return language profiles.
     */
    public static synchronized String[] getLanguageProfiles(Context context) {
        if (languageProfiles == null) {
            List<String> languageProfileList = new ArrayList<>(languageProfileMap.size());
            for (int id : languageProfileMap.values()) {
                languageProfileList.add(context.getString(id));
            }
            languageProfiles = languageProfileList.toArray(new String[languageProfileList.size()]);
        }
        return languageProfiles;
    }

    /**
     * Get language detector.
     * @param context context.
     * @param lang language text.
     * @return detector.
     */
    public static Detector getDetector(@NonNull Context context, String lang) {
        try {
            List<String> profileList = new ArrayList<>();
            profileList.add(context.getString(languageProfileMap.get("en")));

            Integer stringId =languageProfileMap.get(lang);
            if (stringId == null)
                return null;
            final String profile = context.getString(stringId);
            profileList.add(profile);

            if (profileList.size() < 2)
                return null; // needs more than 2 profile to get detector
            DetectorFactory.clear();
            DetectorFactory.loadProfile(profileList);
            return DetectorFactory.create();
        } catch (LangDetectException e) {
            Logger.e(e);
            return null;
        }
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
            DetectorFactory.loadProfile(Arrays.asList(getLanguageProfiles(context)));
        }
        return DetectorFactory.create();
    }



    /**
     * 引数で与えられた最初のnull以外の値を返す.
     * @param objects オブジェクト.
     * @return 最初のnull以外のオブジェクト。全てnullの場合はnull.
     */
    public static Object coalesce(Object... objects) {
        if (objects == null)
            return null;
        for (Object obj : objects) {
            if (obj != null)
                return obj;
        }
        return null;
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
