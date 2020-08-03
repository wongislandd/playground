package com.cwong51799.api.randomfactapi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fact(val id : String, val text : String, val source : String, val source_url : String, val language : String, val permalink : String)
