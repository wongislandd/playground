package com.cwong51799.api.opentriviadb.triviautils

/**
 * Applies formatting since the API returns some weird format for " and '
 */

object TriviaUtils {
    fun formatToHtml(str: String): String {
        var strCopy: String = str
        var alternator = 0
        while (strCopy.contains("&quot;")) {
            if (alternator == 0) {
                strCopy = strCopy.replaceFirst("&quot;", "<b>")
                alternator = 1
            } else {
                strCopy = strCopy.replaceFirst("&quot;", "</b>")
                alternator = 0
            }
        }
        strCopy = strCopy.replace("&#39;", "'")
        return strCopy
    }
}