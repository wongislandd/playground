package com.cwong51799.api.pokeapi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.cwong51799.api.R
import com.cwong51799.api.pokeapi.custom_ui.HeightWeightView
import com.cwong51799.api.pokeapi.viewmodels.PokeAPIViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.Pokemon

class DetailedPokemonFragment : Fragment() {
    private lateinit var viewModel: PokeAPIViewModel
    private val PokeApi = PokeApiClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_pokemon_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(PokeAPIViewModel::class.java)
        viewModel.currentPokemon.observe(viewLifecycleOwner) { pokemon ->
            populatePokemonInfo(view, pokemon)
        }
        GlobalScope.launch {
            viewModel.setPokemon(PokeApi.getPokemon(arguments?.getInt("pokemonId") ?: 1))
        }

    }

    private fun populatePokemonInfo(view: View, pokemon: Pokemon) {
        val heightWeightView = view.findViewById<HeightWeightView>(R.id.heightWeightView)
        val pokemonImageView = view.findViewById<ImageView>(R.id.miniPokemonView)
        val pokemonNameTV = view.findViewById<TextView>(R.id.pokemonNameTV)
        context?.let { Glide.with(it).load(pokemon.sprites.frontDefault).into(pokemonImageView) }
        pokemonNameTV.text = pokemon.name.capitalize()
        heightWeightView.setHeightAndWeight(pokemon.height, pokemon.weight)
    }

    companion object {
        private val TAG = "DetailedPokemonFragment"
        fun newInstance() = DetailedPokemonFragment()
    }



}