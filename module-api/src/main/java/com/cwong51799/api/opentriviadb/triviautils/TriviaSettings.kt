package com.cwong51799.api.opentriviadb.triviautils

import com.cwong51799.api.opentriviadb.network.TriviaQuestion

data class TriviaSettings (var numQuestions : Int, var category : Int?, var difficulty : String)

data class TriviaQuestionWithStatus(var triviaQuestion : TriviaQuestion, var used : Boolean = false)