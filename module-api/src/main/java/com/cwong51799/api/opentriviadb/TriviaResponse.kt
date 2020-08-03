package com.cwong51799.api.opentriviadb

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TriviaResponse(val response_code : Int, val triviaResults : List<TriviaResult>)


@JsonClass(generateAdapter = true)
data class TriviaResult(val category : String, val type : String, val difficulty : String, val question : String,
                        val correct_answer : String, val incorrect_answers : List<String>)


