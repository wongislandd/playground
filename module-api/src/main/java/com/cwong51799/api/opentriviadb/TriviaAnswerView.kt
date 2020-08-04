package com.cwong51799.api.opentriviadb

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.HtmlCompat
import com.cwong51799.api.R
import com.cwong51799.api.opentriviadb.triviautils.TriviaUtils
import com.cwong51799.api.utils.API
import kotlinx.android.synthetic.main.api_option_view.view.*
import kotlinx.android.synthetic.main.trivia_answer_view.view.*

class TriviaAnswerView @JvmOverloads constructor(
    answerText : String,
    correct : Boolean,
    context : Context,
    attrs : AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init{
        LayoutInflater.from(context).inflate(R.layout.trivia_answer_view,this, true)
        triviaOptionTV.text = HtmlCompat.fromHtml(
            TriviaUtils.formatToHtml(answerText),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }

    fun selectAnswer() {
        triviaOptionParentView.setBackgroundResource(R.color.colorPrimary)
    }

    fun deselectAnswer() {
        triviaOptionParentView.setBackgroundResource(0)
    }
}