package com.cwong51799.api.pokeapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
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
import me.sargunvohra.lib.pokekotlin.model.Pokemon

/**
 * A simple [Fragment] subclass.
 * Use the [PokeAPI.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokeAPIFragment : Fragment() {
    private lateinit var viewModel: PokeAPIViewModel
    private lateinit var navController : NavController
    private lateinit var queryResult : TextView
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
        val pokemonIDSelector = view.findViewById<EditText>(R.id.pokemonNumSelectorET)
        val pokemonSearchBtn = view.findViewById<TextView>(R.id.pokemonSearchBtn)
        viewModel.currentPokemon.observe(viewLifecycleOwner) {pokemon ->
            generatePokemonInformation(pokemon)
        }
        pokemonSearchBtn.setOnClickListener{
            searchAPokemon(Integer.parseInt(pokemonIDSelector.text.toString()))
        }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun searchAPokemon(id: Int){
        GlobalScope.launch(Dispatchers.IO){
            viewModel.setPokemon(PokeApi.getPokemon(id))
        }
    }

    private fun generatePokemonInformation(pokemon : Pokemon) {





    }

    companion object {
        private val TAG = "PokeAPIFragment"
    }
}