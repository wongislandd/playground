package com.cwong51799.api.opentriviadb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriviaViewModel : ViewModel()  {
    val currentQuestion = MutableLiveData<TriviaResult>()
    val selectedAnswer = MutableLiveData<Pair<String, Boolean>>()

    var numCorrect = 0
    var numIncorrect = 0

    fun isSelectedAnswerCorrect() : Boolean {
        return selectedAnswer.value?.second ?: false
    }



}
