package com.cwong51799.api.utils

import com.cwong51799.api.APIActivity
import com.cwong51799.api.R

data class API(var name : String, var backgroundResource : Int)

object APIUtils {
    val apiList = listOf(
        API("PokeAPI", R.drawable.pokeapi_background)
    )
}
