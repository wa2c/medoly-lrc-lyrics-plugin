package com.wa2c.android.medoly.plugin.action.lrclyrics.search

import java.util.*

/**
 * Search result.
 */
class Result {
    /** Result info list.  */
    var infoList: ArrayList<ResultItem>? = null
    /** Page count.  */
    var pageCount: Int = 0
    /** Current page.  */
    var currentPage: Int = 0
    /** Valid.  */
    var isValid: Boolean = false
}
