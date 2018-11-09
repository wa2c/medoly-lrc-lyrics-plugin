package com.wa2c.android.medoly.plugin.action.lrclyrics.search

/**
 * @title ViewLyricsSearcher
 * @author PedroHLC
 * @email pedro.laracampos@gmail.com
 * @date (DD-MM-YYYY) FirstRls: 02-08-2012 02-06-2012 LastUpd: 03-08-2012
 * @version 0.9.03-beta
 * @works Search and get results
 */
/**
 * Modified:  wa2c.
 * 2017-02-21: modified.
 * 2018-01-28: changed to kotlin.
 */

import org.w3c.dom.Element
import org.xml.sax.SAXException
import timber.log.Timber
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException


object ViewLyricsSearcher {
    /*
     * Needed data
     */
    private const val url = "http://search.crintsoft.com/searchlyrics.htm"
    //ACTUAL: http://search.crintsoft.com/searchlyrics.htm
    //CLASSIC: http://www.viewlyrics.com:1212/searchlyrics.htm

    private const val clientUserAgent = "MiniLyrics"
    //NORMAL: MiniLyrics <version> for <player>
    //EXAMPLE: MiniLyrics 7.6.44 for Windows Media Player
    //MOBILE: MiniLyrics4Android

    private const val clientTag = "client=\"ViewLyricsOpenSearcher\""
    //NORMAL: MiniLyrics
    //MOBILE: MiniLyricsForAndroid

    private const val searchQueryBase = "<?xml version='1.0' encoding='utf-8' ?><searchV1 artist=\"%s\" title=\"%s\" OnlyMatched=\"1\" %s/>"

    private const val searchQueryPage = " RequestPage='%d'"

    private val magickey = "Mlv1clt4.0".toByteArray()

    private const val LYRICS_ENCODING = "UTF-8"




    /**
     * Download lyrics bytes.
     * @param urlText Lyrics URL.
     * @return Lyrics bytes.
     */
    @Throws(IOException::class)
    fun downloadLyricsBytes(urlText: String?): ByteArray? {
        if (urlText == null)
            return null

        val url = URL(urlText)
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
        con.connect()
        val status = con.responseCode

        if (status != HttpURLConnection.HTTP_OK) {
            // failed
            return null
        }

        var lyricsBytes: ByteArray? = null
        con.inputStream.use { inputStream ->
            ByteArrayOutputStream().use { bout ->
                val buffer = ByteArray(4096)
                while (true) {
                    val len = inputStream.read(buffer)
                    if (len < 0) {
                        break
                    }
                    bout.write(buffer, 0, len)
                }
                lyricsBytes = bout.toByteArray()
            }
        }
        return lyricsBytes
    }

    /**
     * Download lyrics.
     * @param urlText Lyrics URL.
     * @return Lyrics text.
     */
    @Throws(IOException::class)
    fun downloadLyricsText(urlText: String?): String? {
        val lyricsBytes = downloadLyricsBytes(urlText)
        return if (lyricsBytes == null || lyricsBytes.isEmpty()) null else String(lyricsBytes, charset(LYRICS_ENCODING))
    }


    /*
     * Search function
     */
    @Throws(IOException::class, NoSuchAlgorithmException::class, SAXException::class, ParserConfigurationException::class)
    fun search(title: String, artist: String, page: Int): Result? {
        return searchQuery(
                String.format(searchQueryBase, artist, title, clientTag + String.format(Locale.getDefault(), searchQueryPage, page)) // Create XMLQuery String
        )
    }

    @Throws(IOException::class, NoSuchAlgorithmException::class, SAXException::class, ParserConfigurationException::class)
    private fun searchQuery(searchQuery: String): Result? {

        val searchUrl = URL(url)
        val con = searchUrl.openConnection() as HttpURLConnection
        con.requestMethod = "POST"
        con.instanceFollowRedirects = false
        con.setRequestProperty("User-Agent", clientUserAgent)
        con.connect()

        // Request
        con.outputStream.use { s ->
            s.write(assembleQuery(searchQuery.toByteArray(charset("UTF-8"))))
            s.flush()
            s.close()
            if (con.responseCode != HttpURLConnection.HTTP_OK)
                return null
        }

        // Get full result
        BufferedReader(InputStreamReader(con.inputStream, "ISO_8859_1")).use { rd ->
            val full = rd.readText()

            // Decrypt, parse, store, and return the result list
            val r = parseResultXML(decryptResultXML(full))
            val inf = r.infoList
            Timber.d(inf?.toString())
            return r
        }
    }

    /*
     * Add MD5 and Encrypts Search Query
     */

    @Throws(NoSuchAlgorithmException::class, IOException::class)
    private fun assembleQuery(value: ByteArray): ByteArray {
        // Create the variable POG to be used in a dirt code
        val pog = ByteArray(value.size + magickey.size) //TODO Give a better name then POG

        // POG = XMLQuery + Magic Key
        System.arraycopy(value, 0, pog, 0, value.size)
        System.arraycopy(magickey, 0, pog, value.size, magickey.size)

        // POG is hashed using MD5
        val pog_md5 = MessageDigest.getInstance("MD5").digest(pog)

        //TODO Thing about using encryption or k as 0...
        // Prepare encryption key
        val j = value.sumBy { it.toInt() }
        val k = (j / value.size).toByte().toInt()

        // Value is encrypted
        for (m in value.indices)
            value[m] = (k xor value[m].toInt()).toByte()

        // Prepare result code
        val result = ByteArrayOutputStream()

        // Write Header
        result.write(0x02)
        result.write(k)
        result.write(0x04)
        result.write(0x00)
        result.write(0x00)
        result.write(0x00)

        // Write Generated MD5 of POG problaby to be used in a search cache
        result.write(pog_md5)

        // Write encrypted value
        result.write(value)

        // Return magic encoded query
        return result.toByteArray()
    }

    /*
     * Decrypts only the XML from the entire result
     */

    private fun decryptResultXML(value: String): String {
        // Get Magic key value
        val magickey = value[1]

        // Prepare output
        val neomagic = ByteArrayOutputStream()

        // Decrypts only the XML
        for (i in 22 until value.length)
            neomagic.write((value[i].toInt() xor magickey.toInt()).toByte().toInt())

        // Return value
        return neomagic.toString()
    }

    /*
     * Create the ArrayList<LyricInfo>
     */

    private fun readIntFromAttr(elem: Element, attr: String, def: Int): Int {
        val data = elem.getAttribute(attr)
        try {
            if (!data.isNullOrEmpty())
                return Integer.valueOf(data)!!
        } catch (e: NumberFormatException) {
            Timber.d(e)
        }

        return def
    }

    private fun readFloatFromAttr(elem: Element, attr: String, def: Float): Double {
        val data = elem.getAttribute(attr)
        try {
            if (!data.isNullOrEmpty())
                return java.lang.Double.valueOf(data)!!
        } catch (e: NumberFormatException) {
            Timber.d(e)
        }

        return def.toDouble()
    }

    private fun readStrFromAttr(elem: Element, attr: String, def: String): String {
        val data = elem.getAttribute(attr)
        try {
            if (!data.isNullOrEmpty())
                return data
        } catch (e: NumberFormatException) {
            Timber.d(e)
        }

        return def
    }

    @Throws(SAXException::class, IOException::class, ParserConfigurationException::class)
    private fun parseResultXML(resultXML: String): Result {
        val result = Result()

        // Create array for storing the results
        val availableLyrics = ArrayList<ResultItem>()

        // Parse XML
        val resultBA = ByteArrayInputStream(resultXML.toByteArray(charset("UTF-8")))
        val resultRootElem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resultBA).documentElement

        result.currentPage = readIntFromAttr(resultRootElem, "CurPage", 0)
        result.pageCount = readIntFromAttr(resultRootElem, "PageCount", 1)
        val server_url = readStrFromAttr(resultRootElem, "server_url", "http://www.viewlyrics.com/")
        //result.setMessage(readStrFromAttr(resultRootElem, "message", ""));

        val resultItemList = resultRootElem.getElementsByTagName("fileinfo")
        for (i in 0 until resultItemList.length) {
            val itemElem = resultItemList.item(i) as Element
            val itemInfo = ResultItem()
            itemInfo.lyricURL = server_url + readStrFromAttr(itemElem, "link", "")
            itemInfo.musicArtist = readStrFromAttr(itemElem, "artist", "")
            itemInfo.musicTitle = readStrFromAttr(itemElem, "title", "")
            itemInfo.musicAlbum = readStrFromAttr(itemElem, "album", "")
            itemInfo.lyricsFileName = readStrFromAttr(itemElem, "filename", "")
            itemInfo.lyricUploader = readStrFromAttr(itemElem, "uploader", "")
            itemInfo.lyricRate = readFloatFromAttr(itemElem, "rate", 0.0f)
            itemInfo.lyricRatesCount = readIntFromAttr(itemElem, "ratecount", 0)
            itemInfo.lyricDownloadsCount = readIntFromAttr(itemElem, "downloads", 0)
            //itemInfo.setFType(readIntFromAttr(itemElem, "file_type", 0));
            //itemInfo.setMatchVal(readFloatFromAttr(itemElem, "match_value", 0.0F));
            //itemInfo.setTimeLenght(readIntFromAttr(itemElem, "timelength", 0));


            availableLyrics.add(itemInfo)
        }

        // Add all founded lyrics founded to result
        result.infoList = availableLyrics

        return result
    }

}
