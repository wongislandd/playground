package com.cwong51799.api.randomfactapi.network

import com.cwong51799.api.randomfactapi.network.FactResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomFactServices {
    @GET("random.json?language=en")
    fun getFact() : Call<FactResponse>
}