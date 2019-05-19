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
            put("ko", R.raw.ko)
            put("lv", R.raw.lv)
            put("et", R.raw.et)
            put("lt", R.raw.lt)
            put("vi", R.raw.vi)
            put("sl", R.raw.sl)
            put("ro", R.raw.ro)

            // normal size profiles
            put("af", R.raw.af)
            put("ar", R.raw.ar)
            put("bg", R.raw.bg)
            put("bn", R.raw.bn)
            put("cs", R.raw.cs)
            put("da", R.raw.da)
            put("de", R.raw.de)
            put("el", R.raw.el)
            put("en", R.raw.en)
            put("es", R.raw.es)
            //put("et", R.raw.et)
            put("fa", R.raw.fa)
            put("fi", R.raw.fi)
            put("fr", R.raw.fr)
            put("gu", R.raw.gu)
            put("he", R.raw.he)
            put("hi", R.raw.hi)
            put("hr", R.raw.hr)
            put("hu", R.raw.hu)
            put("id", R.raw.id)
            put("it", R.raw.it)
            put("ja", R.raw.ja)
            put("kn", R.raw.kn)
            //put("ko",  R.raw.ko)
            //put("lt",  R.raw.lt)
            //put("lv",  R.raw.lv)
            put("mk", R.raw.mk)
            put("ml", R.raw.ml)
            put("mr", R.raw.mr)
            put("ne", R.raw.ne)
            put("nl", R.raw.nl)
            put("no", R.raw.no)
            put("pa", R.raw.pa)
            put("pl", R.raw.pl)
            put("pt", R.raw.pt)
            //put("ro",  R.raw.ro)
            put("ru", R.raw.ru)
            put("sk", R.raw.sk)
            //put("sl",  R.raw.sl)
            put("so", R.raw.so)
            put("sq", R.raw.sq)
            put("sv", R.raw.sv)
            put("sw", R.raw.sw)
            put("ta", R.raw.ta)
            put("te", R.raw.te)
            put("th", R.raw.th)
            put("tl", R.raw.tl)
            put("tr", R.raw.tr)
            put("uk", R.raw.uk)
            put("ur", R.raw.ur)
            //put("vi",  R.raw.vi)
            put("zh-cn", R.raw.zh_cn)
            put("zh-tw", R.raw.zh_tw)
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
            Timber.d("Detector creating begin. Core: %s", coreCount)

            val executorService = Executors.newFixedThreadPool(coreCount)
            val futures = ArrayList<Future<LangProfile>>(languageProfileMap.size)
            for (item in languageProfileMap) {
                futures.add(executorService.submit(ProfileCreator(context, item.key, item.value)))
            }

            Timber.d("Adding profiles.")
            for (i in futures.indices) {
                try {
                    DetectorFactory.addProfile(futures[i].get(), i, 200)
                } catch (e: Exception) {
                    Timber.e(e)
                }

            }

            executorService.shutdown()
            Timber.d("Detector creating end. Time: %s", (System.currentTimeMillis() - startTime))
        }

        return DetectorFactory.create()
    }

    /**
     * Profile creator.
     */
    private class ProfileCreator internal constructor(val context: Context, private val key: String, private val resourceId: Int) : Callable<LangProfile> {

        @Throws(Exception::class)
        override fun call(): LangProfile {
            context.resources.openRawResource(resourceId).use {
                it.reader().use { reader ->
                    Timber.d("creating begin: %s", key)
                    val profile = gson.fromJson(reader, LangProfile::class.java)
                    Timber.d("creating end: %s", key)
                    return profile
                }
            }
        }

        companion object {
            internal var gson = Gson()
        }
    }


}
