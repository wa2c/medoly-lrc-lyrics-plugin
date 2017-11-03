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

import java.util.Map;
import java.util.TreeMap;


/**
 * Detect factory utility.
 */
public class DetectorFactoryUtil {

    /**
     * Language profiles map.
     */
    private static final Map<String, LangProfile> languageProfileMap = new TreeMap<String, LangProfile>() {{
        put( "af" , new Profile_af() );
        put( "ar" , new Profile_ar() );
        put( "bg" , new Profile_bg() );
        put( "bn" , new Profile_bn() );
        put( "cs" , new Profile_cs() );
        put( "da" , new Profile_da() );
        put( "de" , new Profile_de() );
        put( "el" , new Profile_el() );
        put( "en" , new Profile_en() );
        put( "es" , new Profile_es() );
        put( "et" , new Profile_et() );
        put( "fa" , new Profile_fa() );
        put( "fi" , new Profile_fi() );
        put( "fr" , new Profile_fr() );
        put( "gu" , new Profile_gu() );
        put( "he" , new Profile_he() );
        put( "hi" , new Profile_hi() );
        put( "hr" , new Profile_hr() );
        put( "hu" , new Profile_hu() );
        put( "id" , new Profile_id() );
        put( "it" , new Profile_it() );
        put( "ja" , new Profile_ja() );
        put( "kn" , new Profile_kn() );
        put( "ko" , new Profile_ko() );
        put( "lt" , new Profile_lt() );
        put( "lv" , new Profile_lv() );
        put( "mk" , new Profile_mk() );
        put( "ml" , new Profile_ml() );
        put( "mr" , new Profile_mr() );
        put( "ne" , new Profile_ne() );
        put( "nl" , new Profile_nl() );
        put( "no" , new Profile_no() );
        put( "pa" , new Profile_pa() );
        put( "pl" , new Profile_pl() );
        put( "pt" , new Profile_pt() );
        put( "ro" , new Profile_ro() );
        put( "ru" , new Profile_ru() );
        put( "sk" , new Profile_sk() );
        put( "sl" , new Profile_sl() );
        put( "so" , new Profile_so() );
        put( "sq" , new Profile_sq() );
        put( "sv" , new Profile_sv() );
        put( "sw" , new Profile_sw() );
        put( "ta" , new Profile_ta() );
        put( "te" , new Profile_te() );
        put( "th" , new Profile_th() );
        put( "tl" , new Profile_tl() );
        put( "tr" , new Profile_tr() );
        put( "uk" , new Profile_uk() );
        put( "ur" , new Profile_ur() );
        put( "vi" , new Profile_vi() );
        put( "zh-cn" , new Profile_zh_cn() );
        put( "zh-tw" , new Profile_zh_tw() );
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
            int index = 0;
            for (LangProfile p : languageProfileMap.values()) {
                ++index;
                DetectorFactory.addProfile(p, index, languageProfileMap.size());
            }
        }
        return DetectorFactory.create();
    }

}
