package com.wa2c.android.medoly.plugin.action.viewlyrics.search;

import java.util.ArrayList;

import lombok.Data;

/**
 * Search result.
 */
@Data
public class Result {
    /** Result info list. */
    private ArrayList<ResultItem> infoList;
    /** Page count. */
    private int pageCount;
    /** Current page. */
    private int currentPage;
    /** Valid. */
    private boolean valid;
}
