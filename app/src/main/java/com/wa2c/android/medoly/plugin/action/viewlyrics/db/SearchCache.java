package com.wa2c.android.medoly.plugin.action.viewlyrics.db;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.Index;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;
import com.google.gson.Gson;
import com.wa2c.android.medoly.plugin.action.viewlyrics.search.ResultItem;

import java.util.Date;

/**
 * Search condition. (Orma Model)
 */
@Table(value = "search_cache", indexes = @Index(value= {"title", "artist"}))
public class SearchCache {

    /** Key. */
    @PrimaryKey(autoincrement = true)
    public long _id;

    /** Search title. */
    @Column(indexed = true)
    public String title;

    /** Search artist. */
    @Nullable
    @Column(indexed = true)
    public String artist;

    /** Search language. */
    @Nullable
    @Column
    public String language;

    @Nullable
    @Column
    public String from;


    @Nullable
    @Column
    public String file_name;

    /** Search result. (JSON)  */
    @Column
    public String result;

    /** Added date. */
    @Nullable
    @Column(defaultExpr = "CURRENT_TIMESTAMP")
    public Date date_added;

    /** Modified date. */
    @Nullable
    @Column(defaultExpr = "CURRENT_TIMESTAMP")
    public Date date_modified;




    /**
     * Get ResultItem from result field.
     * @return
     */
    public ResultItem getResultItem() {
        if (TextUtils.isEmpty(result))
            return null;
        return (new Gson()).fromJson(result, ResultItem.class);
    }

    /**
     * Set ResultItem to result field.
     * @param item
     * @return
     */
    public void setResultItem(ResultItem item) {
        if (item == null)
            return;
        result = (new Gson()).toJson(item);
    }

}
