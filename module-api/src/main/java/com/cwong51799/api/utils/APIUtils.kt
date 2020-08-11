package com.cwong51799.api.utils

import com.cwong51799.api.R
import com.cwong51799.api.opentriviadb.network.TriviaServices
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

data class API(var name : String, var baseUrl : String, var backgroundResource : Int, var associatedFragment : Int)

object APIUtils {
    private const val pokeApiBaseUrl = "https://pokeapi.co/"
    private const val randomFactApiBaseUrl = "https://uselessfacts.jsph.pl/"
    private const val triviaApiBaseUrl = "https://opentdb.com/"

    val POKE_API = API("PokeAPI", pokeApiBaseUrl, R.drawable.pokeapi_background, R.id.pokeAPIFragment)
    val RANDOM_FACT_API = API("RandomFact", randomFactApiBaseUrl, R.drawable.randomfact_background, R.id.randomFactAPIFragment)
    val TRIVIA_API = API("TriviaApi", triviaApiBaseUrl, R.drawable.opentdb_background, R.id.triviaOptionsFragment)

    val TriviaServices = Retrofit.Builder().baseUrl(triviaApiBaseUrl).addConverterFactory(
    MoshiConverterFactory.create()).build().create(TriviaServices::class.java)

    val apiList = listOf(
        TRIVIA_API, RANDOM_FACT_API, POKE_API
    )


}
