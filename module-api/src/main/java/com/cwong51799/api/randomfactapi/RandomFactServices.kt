package com.cwong51799.api.randomfactapi

import retrofit2.Call
import retrofit2.http.GET

interface RandomFactServices {
    @GET("random.json?language=en")
    fun getFact() : Call<FactResponse>
}