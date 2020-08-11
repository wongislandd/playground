//package com.cwong51799.api.pokeapi.network
//
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//
//interface PokeServices {
//    @GET("/pokemon/{name}")
//    fun getPokemon(
//        @Path("name") name : String
//    ): Call<PokemonResponse>
//}