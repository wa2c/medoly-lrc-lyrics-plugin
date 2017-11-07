package com.cybozu.labs.langdetect;

import com.cybozu.labs.langdetect.profiles.Profile_af;
import com.cybozu.labs.langdetect.profiles.Profile_ar;
import com.cybozu.labs.langdetect.profiles.Profile_bg;
import com.cybozu.labs.langdetect.profiles.Profile_bn;
import com.cybozu.labs.langdetect.profiles.Profile_cs;
import com.cybozu.labs.langdetect.profiles.Profile_da;
import com.cybozu.labs.langdetect.profiles.Profile_de;
import com.cybozu.labs.langdetect.profiles.Profile_el;
import com.cybozu.labs.langdetect.profiles.Profile_en;
import com.cybozu.labs.langdetect.profiles.Profile_es;
import com.cybozu.labs.langdetect.profiles.Profile_et;
import com.cybozu.labs.langdetect.profiles.Profile_fa;
import com.cybozu.labs.langdetect.profiles.Profile_fi;
import com.cybozu.labs.langdetect.profiles.Profile_fr;
import com.cybozu.labs.langdetect.profiles.Profile_gu;
import com.cybozu.labs.langdetect.profiles.Profile_he;
import com.cybozu.labs.langdetect.profiles.Profile_hi;
import com.cybozu.labs.langdetect.profiles.Profile_hr;
import com.cybozu.labs.langdetect.profiles.Profile_hu;
import com.cybozu.labs.langdetect.profiles.Profile_id;
import com.cybozu.labs.langdetect.profiles.Profile_it;
import com.cybozu.labs.langdetect.profiles.Profile_ja;
import com.cybozu.labs.langdetect.profiles.Profile_kn;
import com.cybozu.labs.langdetect.profiles.Profile_ko;
import com.cybozu.labs.langdetect.profiles.Profile_lt;
import com.cybozu.labs.langdetect.profiles.Profile_lv;
import com.cybozu.labs.langdetect.profiles.Profile_mk;
import com.cybozu.labs.langdetect.profiles.Profile_ml;
import com.cybozu.labs.langdetect.profiles.Profile_mr;
import com.cybozu.labs.langdetect.profiles.Profile_ne;
import com.cybozu.labs.langdetect.profiles.Profile_nl;
import com.cybozu.labs.langdetect.profiles.Profile_no;
import com.cybozu.labs.langdetect.profiles.Profile_pa;
import com.cybozu.labs.langdetect.profiles.Profile_pl;
import com.cybozu.labs.langdetect.profiles.Profile_pt;
import com.cybozu.labs.langdetect.profiles.Profile_ro;
import com.cybozu.labs.langdetect.profiles.Profile_ru;
import com.cybozu.labs.langdetect.profiles.Profile_sk;
import com.cybozu.labs.langdetect.profiles.Profile_sl;
import com.cybozu.labs.langdetect.profiles.Profile_so;
import com.cybozu.labs.langdetect.profiles.Profile_sq;
import com.cybozu.labs.langdetect.profiles.Profile_sv;
import com.cybozu.labs.langdetect.profiles.Profile_sw;
import com.cybozu.labs.langdetect.profiles.Profile_ta;
import com.cybozu.labs.langdetect.profiles.Profile_te;
import com.cybozu.labs.langdetect.profiles.Profile_th;
import com.cybozu.labs.langdetect.profiles.Profile_tl;
import com.cybozu.labs.langdetect.profiles.Profile_tr;
import com.cybozu.labs.langdetect.profiles.Profile_uk;
import com.cybozu.labs.langdetect.profiles.Profile_ur;
import com.cybozu.labs.langdetect.profiles.Profile_vi;
import com.cybozu.labs.langdetect.profiles.Profile_zh_cn;
import com.cybozu.labs.langdetect.profiles.Profile_zh_tw;
import com.cybozu.labs.langdetect.util.LangProfile;
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

    /**
     * Language profiles map.
     */
    private static final Map<String, Class<? extends LangProfile>> languageProfileMap = new LinkedHashMap<String, Class<? extends LangProfile>>() {{
        // large size profiles (first reading)
        put("ko", Profile_ko.class);
        put("lv", Profile_lv.class);
        put("et", Profile_et.class);
        put("lt", Profile_lt.class);
        put("vi", Profile_vi.class);
        put("sl", Profile_sl.class);
        put("ro", Profile_ro.class);

        // normal size profiles
        put("af", Profile_af.class);
        put("ar", Profile_ar.class);
        put("bg", Profile_bg.class);
        put("bn", Profile_bn.class);
        put("cs", Profile_cs.class);
        put("da", Profile_da.class);
        put("de", Profile_de.class);
        put("el", Profile_el.class);
        put("en", Profile_en.class);
        put("es", Profile_es.class);
        //put("et", Profile_et.class);
        put("fa", Profile_fa.class);
        put("fi", Profile_fi.class);
        put("fr", Profile_fr.class);
        put("gu", Profile_gu.class);
        put("he", Profile_he.class);
        put("hi", Profile_hi.class);
        put("hr", Profile_hr.class);
        put("hu", Profile_hu.class);
        put("id", Profile_id.class);
        put("it", Profile_it.class);
        put("ja", Profile_ja.class);
        put("kn", Profile_kn.class);
        //put("ko", Profile_ko.class);
        //put("lt", Profile_lt.class);
        //put("lv", Profile_lv.class);
        put("mk", Profile_mk.class);
        put("ml", Profile_ml.class);
        put("mr", Profile_mr.class);
        put("ne", Profile_ne.class);
        put("nl", Profile_nl.class);
        put("no", Profile_no.class);
        put("pa", Profile_pa.class);
        put("pl", Profile_pl.class);
        put("pt", Profile_pt.class);
        //put("ro", Profile_ro.class);
        put("ru", Profile_ru.class);
        put("sk", Profile_sk.class);
        //put("sl", Profile_sl.class);
        put("so", Profile_so.class);
        put("sq", Profile_sq.class);
        put("sv", Profile_sv.class);
        put("sw", Profile_sw.class);
        put("ta", Profile_ta.class);
        put("te", Profile_te.class);
        put("th", Profile_th.class);
        put("tl", Profile_tl.class);
        put("tr", Profile_tr.class);
        put("uk", Profile_uk.class);
        put("ur", Profile_ur.class);
        //put("vi", Profile_vi.class);
        put("zh-cn", Profile_zh_cn.class);
        put("zh-tw", Profile_zh_tw.class);
    }};

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
    public static synchronized Detector createDetectorAll() throws LangDetectException {
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
            for (final Class<? extends LangProfile> c : languageProfileMap.values()) {
                futures.add(executorService.submit(new ProfileCreator(c)));
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

        private Class<? extends LangProfile> profileClass;

        ProfileCreator(Class<? extends LangProfile> profileClass) {
            this.profileClass = profileClass;
        }

        @Override
        public LangProfile call() throws Exception {
            Logger.d("creating begin: " + profileClass.getName());
            LangProfile p = profileClass.newInstance();
            Logger.d("creating end: " + profileClass.getName());
            return p;
        }
    }


}
