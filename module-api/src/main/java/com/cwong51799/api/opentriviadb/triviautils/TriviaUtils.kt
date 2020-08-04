package com.cwong51799.api.opentriviadb.triviautils

import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.navigation.NavOptions
import com.cwong51799.api.R

/**
 * Applies formatting since the API returns some weird format for " and '
 */

object TriviaUtils {
    fun getFormattedHtmlFromString(str : String) : Spanned {
        return HtmlCompat.fromHtml(formatToHtml(str), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun formatToHtml(str: String): String {
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
        strCopy = strCopy.replace("&#039;", "'")
        return strCopy
    }

    val triviaNavOptions = NavOptions.Builder().setPopUpTo(R.id.APISelector, false).build()
}