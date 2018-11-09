package com.cybozu.labs.langdetect

import android.content.Context
import com.cybozu.labs.langdetect.util.LangProfile
import com.google.gson.Gson
import com.wa2c.android.medoly.plugin.action.lrclyrics.R
import timber.log.Timber
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


/**
 * Detect factory utility.
 */
object DetectorFactoryUtil {

    private val languageProfileMap = object : LinkedHashMap<String, Int>() {
        init {
            // large size profiles (first reading)
            put("ko", R.string.language_profile_ko)
            put("lv", R.string.language_profile_lv)
            put("et", R.string.language_profile_et)
            put("lt", R.string.language_profile_lt)
            put("vi", R.string.language_profile_vi)
            put("sl", R.string.language_profile_sl)
            put("ro", R.string.language_profile_ro)

            // normal size profiles
            put("af", R.string.language_profile_af)
            put("ar", R.string.language_profile_ar)
            put("bg", R.string.language_profile_bg)
            put("bn", R.string.language_profile_bn)
            put("cs", R.string.language_profile_cs)
            put("da", R.string.language_profile_da)
            put("de", R.string.language_profile_de)
            put("el", R.string.language_profile_el)
            put("en", R.string.language_profile_en)
            put("es", R.string.language_profile_es)
            //put("et"    ,  R.string.language_profile_et    );
            put("fa", R.string.language_profile_fa)
            put("fi", R.string.language_profile_fi)
            put("fr", R.string.language_profile_fr)
            put("gu", R.string.language_profile_gu)
            put("he", R.string.language_profile_he)
            put("hi", R.string.language_profile_hi)
            put("hr", R.string.language_profile_hr)
            put("hu", R.string.language_profile_hu)
            put("id", R.string.language_profile_id)
            put("it", R.string.language_profile_it)
            put("ja", R.string.language_profile_ja)
            put("kn", R.string.language_profile_kn)
            //put("ko"    ,  R.string.language_profile_ko    );
            //put("lt"    ,  R.string.language_profile_lt    );
            //put("lv"    ,  R.string.language_profile_lv    );
            put("mk", R.string.language_profile_mk)
            put("ml", R.string.language_profile_ml)
            put("mr", R.string.language_profile_mr)
            put("ne", R.string.language_profile_ne)
            put("nl", R.string.language_profile_nl)
            put("no", R.string.language_profile_no)
            put("pa", R.string.language_profile_pa)
            put("pl", R.string.language_profile_pl)
            put("pt", R.string.language_profile_pt)
            //put("ro"    ,  R.string.language_profile_ro    );
            put("ru", R.string.language_profile_ru)
            put("sk", R.string.language_profile_sk)
            //put("sl"    ,  R.string.language_profile_sl    );
            put("so", R.string.language_profile_so)
            put("sq", R.string.language_profile_sq)
            put("sv", R.string.language_profile_sv)
            put("sw", R.string.language_profile_sw)
            put("ta", R.string.language_profile_ta)
            put("te", R.string.language_profile_te)
            put("th", R.string.language_profile_th)
            put("tl", R.string.language_profile_tl)
            put("tr", R.string.language_profile_tr)
            put("uk", R.string.language_profile_uk)
            put("ur", R.string.language_profile_ur)
            //put("vi"    ,  R.string.language_profile_vi    );
            put("zh-cn", R.string.language_profile_zh_cn)
            put("zh-tw", R.string.language_profile_zh_tw)
        }
    }

    /**
     * Get language names.
     * @return language names.
     */

    val languageNames: Array<String>
        get() = languageProfileMap.keys.toTypedArray()

    /**
     * Get language detector.
     * @return Language detector.
     */
    @Synchronized
    @Throws(LangDetectException::class)
    fun createDetectorAll(context: Context): Detector {
        if (DetectorFactory.getLangList() == null || DetectorFactory.getLangList().size == 0) {
            val startTime = System.currentTimeMillis()
            val coreCount = Runtime.getRuntime().availableProcessors()
            Timber.d("Detector creating begin. Core: " + coreCount)

            val executorService = Executors.newFixedThreadPool(coreCount)
            val futures = ArrayList<Future<LangProfile>>(languageProfileMap.size)
            for (item in languageProfileMap) {
                futures.add(executorService.submit(ProfileCreator(context, item.key, item.value)))
            }

            Timber.d("Adding profiles.")
            for (i in futures.indices) {
                try {
                    DetectorFactory.addProfile(futures[i].get(), i, languageProfileMap.size)
                } catch (e: Exception) {
                    Timber.e(e)
                }

            }

            executorService.shutdown()
            Timber.d("Detector creating end. Time: " + (System.currentTimeMillis() - startTime))
        }

        return DetectorFactory.create()
    }

    /**
     * Profile creator.
     */
    private class ProfileCreator internal constructor(private val context: Context, private val key: String, private val stringId: Int) : Callable<LangProfile> {

        @Throws(Exception::class)
        override fun call(): LangProfile {
            Timber.d("creating begin: " + key)
            val profile = gson.fromJson(context.getString(stringId), LangProfile::class.java)
            Timber.d("creating end: " + key)
            return profile
        }

        companion object {
            internal var gson = Gson()
        }
    }


}
