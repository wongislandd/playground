package com.cwong51799.api.pokeapi.fragments

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cwong51799.api.R
import com.cwong51799.api.opentriviadb.viewmodels.TriviaViewModel
import com.cwong51799.api.pokeapi.viewmodels.PokeAPIViewModel
import com.cwong51799.api.utils.APIViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_poke_api.*
import kotlinx.coroutines.supervisorScope
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * Use the [PokeAPI.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokeAPIFragment : Fragment() {
    private lateinit var viewModel: PokeAPIViewModel
    private lateinit var navController: NavController
    private lateinit var queryResult: TextView
    private lateinit var pokemonIDSelector: EditText
    private lateinit var pokemonSearchBtn: Button
    private lateinit var pokemonNameTV: TextView
    private lateinit var pokemonImageView : ImageView
    private val PokeApi = PokeApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(PokeAPIViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_api, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonIDSelector = view.findViewById<EditText>(R.id.pokemonNumSelectorET)
        pokemonSearchBtn = view.findViewById<Button>(R.id.pokemonSearchBtn)
        pokemonNameTV = view.findViewById<TextView>(R.id.pokemonNameTV)
        pokemonImageView = view.findViewById<ImageView>(R.id.pokemonImageView)
        viewModel.currentPokemon.observe(viewLifecycleOwner) { pokemon ->
            generatePokemonInformation(pokemon)
        }
        // Reset on click
        pokemonIDSelector.setOnClickListener {
            pokemonIDSelector.setText("")
        }
        pokemonSearchBtn.setOnClickListener {
            if (!pokemonIDSelector.text.isEmpty() && isValidId(pokemonIDSelector.text.toString())) {
                searchAPokemon(Integer.parseInt(pokemonIDSelector.text.toString()))
            } else {
                pokemonNameTV.text = POKEMON_ERROR_MSG
                pokemonIDSelector.setText("")
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun isValidId(id : String) : Boolean{
        val idNum = Integer.parseInt(id)
        return idNum in MIN_POKEMON_ID..MAX_POKEMON_ID
    }

    private fun searchAPokemon(id: Int) {
        /* Currently not handling errors well. Such as when a
         search for an ID which doesn't match any Pokemon. */
        GlobalScope.launch {
            viewModel.setPokemon(PokeApi.getPokemon(id))
        }
    }

    private fun generatePokemonInformation(pokemon: Pokemon) {
        pokemonNameTV.text = pokemon.name.capitalize()
        context?.let { Glide.with(it).load(pokemon.sprites.frontDefault).into(pokemonImageView) }
    }

    companion object {
        private val TAG = "PokeAPIFragment"
        private val POKEMON_ERROR_MSG = "Error finding Pokemon data. Valid IDs range from 1-893."
        private val MAX_POKEMON_ID = 893
        private val MIN_POKEMON_ID = 1
    }
}