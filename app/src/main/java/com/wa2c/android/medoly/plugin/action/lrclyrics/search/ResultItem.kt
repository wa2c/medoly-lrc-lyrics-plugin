package com.wa2c.android.medoly.plugin.action.lrclyrics.search

/**
 * Search result info item.
 */
class ResultItem {
    /** Media title.  */
    var musicTitle: String? = null
    /** Media artist.  */
    var musicArtist: String? = null
    /** Media album.  */
    var musicAlbum: String? = null
    /** Media length.  */
    var musicLength: String? = null

    /** Lyric url.  */
    var lyricURL: String? = null
    /** Lyric file name.  */
    var lyricsFileName: String? = null
    /** Lyric uploader.  */
    var lyricUploader: String? = null
    /** Lyric rate.  */
    var lyricRate: Double? = null
    /** Lyric downloadLyricsText count.  */
    var lyricDownloadsCount: Int? = null
    /** Lyric rate count.  */
    var lyricRatesCount: Int? = null

    /** Lyrics.  */
    var lyrics: String? = null
    /** Language.  */
    var language: String? = null
}
