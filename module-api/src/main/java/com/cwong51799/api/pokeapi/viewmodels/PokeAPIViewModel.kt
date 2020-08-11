package com.cwong51799.api.pokeapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.sargunvohra.lib.pokekotlin.model.Pokemon

class PokeAPIViewModel : ViewModel() {
    var currentPokemon = MutableLiveData<Pokemon>()

    fun setPokemon(newPokemon : Pokemon) {
        currentPokemon.postValue(newPokemon)
    }
}