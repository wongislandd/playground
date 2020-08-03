package com.cwong51799.api.opentriviadb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriviaViewModel : ViewModel()  {
    val currentQuestion = MutableLiveData<TriviaResult>()



}
