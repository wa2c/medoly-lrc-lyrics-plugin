package com.wa2c.android.medoly.plugin.action.viewlyrics.search;

/**
 * Search result info item.
 */
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
    /** Lyric downloadLyricsText count. */
    private Integer lyricDownloadsCount;
    /** Lyric rate count. */
    private Integer lyricRatesCount;

    /** Lyrics. */
    private String lyrics;
    /** Language. */
    private String language;

    // Getter / Setter

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public String getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public String getMusicLength() {
        return musicLength;
    }

    public void setMusicLength(String musicLength) {
        this.musicLength = musicLength;
    }

    public String getLyricURL() {
        return lyricURL;
    }

    public void setLyricURL(String lyricURL) {
        this.lyricURL = lyricURL;
    }

    public String getLyricsFileName() {
        return lyricsFileName;
    }

    public void setLyricsFileName(String lyricsFileName) {
        this.lyricsFileName = lyricsFileName;
    }

    public String getLyricUploader() {
        return lyricUploader;
    }

    public void setLyricUploader(String lyricUploader) {
        this.lyricUploader = lyricUploader;
    }

    public Double getLyricRate() {
        return lyricRate;
    }

    public void setLyricRate(Double lyricRate) {
        this.lyricRate = lyricRate;
    }

    public Integer getLyricDownloadsCount() {
        return lyricDownloadsCount;
    }

    public void setLyricDownloadsCount(Integer lyricDownloadsCount) {
        this.lyricDownloadsCount = lyricDownloadsCount;
    }

    public Integer getLyricRatesCount() {
        return lyricRatesCount;
    }

    public void setLyricRatesCount(Integer lyricRatesCount) {
        this.lyricRatesCount = lyricRatesCount;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
