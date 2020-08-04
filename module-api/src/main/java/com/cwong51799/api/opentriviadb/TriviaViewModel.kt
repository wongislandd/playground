package com.cwong51799.api.opentriviadb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cwong51799.api.opentriviadb.network.TriviaResult

class TriviaViewModel : ViewModel()  {
    val currentQuestion = MutableLiveData<TriviaResult>()
    val selectedAnswer = MutableLiveData<Pair<String, Boolean>>()

    var numCorrect = 0
    var numIncorrect = 0

    /**
     * @return true if the selected answer is true
     */
    fun isSelectedAnswerCorrect() : Boolean {
        return selectedAnswer.value?.second ?: false
    }

    /**
     * Resets the question and selected answer
     */
    fun resetQuestion() {
        currentQuestion.value = null
        selectedAnswer.value = null
    }


}
