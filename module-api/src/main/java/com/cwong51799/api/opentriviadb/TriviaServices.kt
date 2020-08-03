package com.cwong51799.api.opentriviadb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaServices {
    @GET("/api.php")
    fun getAQuestion(
        @Query("amount") amount : Int
    ) : Call<TriviaResponse>
}