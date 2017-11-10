package com.cybozu.labs.langdetect;

import android.content.Context;

import com.cybozu.labs.langdetect.util.LangProfile;
import com.google.gson.Gson;
import com.wa2c.android.medoly.plugin.action.lrclyrics.R;
import com.wa2c.android.medoly.plugin.action.lrclyrics.util.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Detect factory utility.
 */
public class DetectorFactoryUtil {

    private static final Map<String, Integer> languageProfileMap = new LinkedHashMap<String, Integer>() {
        {
            // large size profiles (first reading)
            put("ko", R.string.language_profile_ko);
            put("lv", R.string.language_profile_lv);
            put("et", R.string.language_profile_et);
            put("lt", R.string.language_profile_lt);
            put("vi", R.string.language_profile_vi);
            put("sl", R.string.language_profile_sl);
            put("ro", R.string.language_profile_ro);

            // normal size profiles
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
            //put("et"    ,  R.string.language_profile_et    );
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
            //put("ko"    ,  R.string.language_profile_ko    );
            //put("lt"    ,  R.string.language_profile_lt    );
            //put("lv"    ,  R.string.language_profile_lv    );
            put("mk"    ,  R.string.language_profile_mk    );
            put("ml"    ,  R.string.language_profile_ml    );
            put("mr"    ,  R.string.language_profile_mr    );
            put("ne"    ,  R.string.language_profile_ne    );
            put("nl"    ,  R.string.language_profile_nl    );
            put("no"    ,  R.string.language_profile_no    );
            put("pa"    ,  R.string.language_profile_pa    );
            put("pl"    ,  R.string.language_profile_pl    );
            put("pt"    ,  R.string.language_profile_pt    );
            //put("ro"    ,  R.string.language_profile_ro    );
            put("ru"    ,  R.string.language_profile_ru    );
            put("sk"    ,  R.string.language_profile_sk    );
            //put("sl"    ,  R.string.language_profile_sl    );
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
            //put("vi"    ,  R.string.language_profile_vi    );
            put("zh-cn" ,  R.string.language_profile_zh_cn );
            put("zh-tw" ,  R.string.language_profile_zh_tw );
        }
    };

    /**
     * Get language names.
     * @return language names.
     */

    public static String[] getLanguageNames() {
        return languageProfileMap.keySet().toArray(new String[languageProfileMap.size()]);
    }

    /**
     * Get language detector.
     * @return Language detector.
     */
    public static synchronized Detector createDetectorAll(Context context) throws LangDetectException {
        if (DetectorFactory.getLangList() == null || DetectorFactory.getLangList().size()  == 0) {
//            int index = 0;
//            for (Class<? extends LangProfile> profileClass : languageProfileMap.values()) {
//                try {
//                    LangProfile p = profileClass.newInstance();
//                    DetectorFactory.addProfile(p, index++, languageProfileMap.size());
//                } catch (InstantiationException | IllegalAccessException e) {
//                    Logger.e(e);
//                }
//            }

            long startTime = System.currentTimeMillis();
            int coreCount = Runtime.getRuntime().availableProcessors();
            Logger.d("Detector creating begin. Core: " + coreCount);

            ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
            List<Future<LangProfile>> futures = new ArrayList<>(languageProfileMap.size());
            for (final String key : languageProfileMap.keySet()) {
                futures.add(executorService.submit(new ProfileCreator(context, key, languageProfileMap.get(key))));
            }

            Logger.d("Adding profiles.");
            for (int i = 0; i < futures.size(); i++) {
                try {
                    DetectorFactory.addProfile(futures.get(i).get(), i, languageProfileMap.size());
                } catch (Exception e) {
                    Logger.e(e);
                }
            }

            executorService.shutdown();
            Logger.d("Detector creating end. Time: " + (System.currentTimeMillis() - startTime));
        }

        return DetectorFactory.create();
    }

    /**
     * Profile creator.
     */
    private static class ProfileCreator implements Callable<LangProfile> {
        private Context context;
        private String key;
        private int stringId;
        static Gson gson = new Gson();

        ProfileCreator(Context context, String key, int stringId) {
            this.context = context;
            this.key = key;
            this.stringId = stringId;
        }

        @Override
        public LangProfile call() throws Exception {
            Logger.d("creating begin: " + key);
            LangProfile profile = gson.fromJson(context.getString(stringId), LangProfile.class);
            Logger.d("creating end: " + key);
            return profile;
        }
    }


}
