package com.cwong51799.api.utils

import com.cwong51799.api.R

data class API(var name : String, var backgroundResource : Int)

object APIUtils {
    const val POKE_API_NAME = "PokeAPI"

    const val RANDOM_FACT_API_NAME = "RandomFact"
    const val RANDOM_FACT_API_BASE_URL = "https://uselessfacts.jsph.pl/"

    const val TRIVIA_API_NAME = "TriviaApi"
    const val TRIVIA_API_BASE_URL = "https://opentdb.com/"


    val apiList = listOf(
        API(POKE_API_NAME, R.drawable.pokeapi_background),
        API(RANDOM_FACT_API_NAME, R.drawable.randomfact_background),
        API(TRIVIA_API_NAME, R.drawable.opentdb_background)
    )
}
