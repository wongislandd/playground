package com.cwong51799.api.utils

import com.cwong51799.api.APIActivity
import com.cwong51799.api.R

data class API(var name : String, var backgroundResource : Int)

object APIUtils {
    val PokeAPIName = "PokeAPI"

    val apiList = listOf(
        API(PokeAPIName, R.drawable.pokeapi_background)
    )
}
