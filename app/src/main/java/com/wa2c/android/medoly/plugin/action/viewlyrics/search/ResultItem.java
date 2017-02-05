package com.wa2c.android.medoly.plugin.action.viewlyrics.search;
import com.cybozu.labs.langdetect.DetectorFactory;

import java.util.Arrays;

import lombok.Data;

/**
 * Search result info item.
 */
@Data
public class ResultItem {
    /** Media title. */
    private String musicTitle;
    /** Media artist. */
    private String musicArtist;
    /** Media album. */
    private String musicAlbum;
    /** Media length. */
    private String musicLength;

    /** Lyric url. */
    private String lyricURL;
    /** Lyric file name. */
    private String lyricsFileName;
    /** Lyric uploader. */
    private String lyricUploader;
    /** Lyric rate. */
    private Double lyricRate;
    /** Lyric download count. */
    private Integer lyricDownloadsCount;
    /** Lyric rate count. */
    private Integer lyricRatesCount;

    /** Lyrics. */
    private String lyrics;
}
