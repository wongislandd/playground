package com.cwong51799.api.pokeapi.fragments

import android.app.AlertDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.core.os.bundleOf
import androidx.core.view.get
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
import com.cwong51799.core.CustomStepperView
import kotlinx.android.synthetic.main.number_dialog.*
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
    private lateinit var pokemonSearcher : Button
    private lateinit var navController: NavController
    private lateinit var pokemonStepper : CustomStepperView
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
        return inflater.inflate(R.layout.fragment_pokedex_selector, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonStepper = view.findViewById<CustomStepperView>(R.id.pokemonStepper)
        pokemonSearcher = view.findViewById<Button>(R.id.search_pokemon)
        pokemonImageView = view.findViewById<ImageView>(R.id.pokemonImageView)
        pokemonNameTV = view.findViewById<TextView>(R.id.pokemonNameTV)
        pokemonStepper.setStepperMinMax(MIN_POKEMON_ID, MAX_POKEMON_ID)
        // If there is currently a pokemon set, keep it at that ID.
        viewModel.currentPokemon.value?.let { pokemon -> pokemonStepper.setCount(pokemon.id) }
        viewModel.currentPokemon.observe(viewLifecycleOwner) { pokemon ->
            generatePokemonInformation(pokemon)
        }
        pokemonStepper.setOnClickListener { v: View? ->
            if (viewModel.currentPokemon.value?.id != pokemonStepper.getCount()) {
                searchAPokemon(pokemonStepper.getCount())
            }
        }
        pokemonImageView.setOnClickListener { v: View? ->
            navigateToDetailedPokemonFragment()
        }
        pokemonSearcher.setOnClickListener { v : View? ->
            val dialogView = LayoutInflater.from(context).inflate(R.layout.number_dialog, null)
            val builder = AlertDialog.Builder(context)
                .setView(dialogView)
                .setTitle("Search a Pokemon")
            val alertDialog = builder.show()
            alertDialog.pokeSearchBtn.setOnClickListener {
                if (!alertDialog.pokeIdInput.text.toString().isEmpty()) {
                    searchAPokemon(alertDialog.pokeIdInput.text.toString().toInt())
                }
                alertDialog.dismiss()
            }
        }
        searchAPokemon(pokemonStepper.getCount())
        super.onViewCreated(view, savedInstanceState)
    }

    private fun searchAPokemon(id: Int) {
        /* Currently not handling errors well. Such as when a
         search for an ID which doesn't match any Pokemon. */
        var idNum = id
        if (idNum > MAX_POKEMON_ID) {
            idNum = MAX_POKEMON_ID
        }
        if (idNum < MIN_POKEMON_ID) {
            idNum = MIN_POKEMON_ID
        }
        pokemonStepper.setCount(idNum)
        GlobalScope.launch {
            viewModel.setPokemon(PokeApi.getPokemon(idNum))
        }
    }

    private fun generatePokemonInformation(pokemon: Pokemon) {
        pokemonNameTV.text = pokemon.name.capitalize()
        context?.let { Glide.with(it).load(pokemon.sprites.frontDefault).into(pokemonImageView) }
    }

    private fun navigateToDetailedPokemonFragment() {
        val bundle = bundleOf("pokemonId" to viewModel.currentPokemon.value?.id)
        navController.navigate(R.id.detailedPokemonFragment, bundle)
    }

    companion object {
        private val TAG = "PokeAPIFragment"
        private val MAX_POKEMON_ID = 893
        private val MIN_POKEMON_ID = 1
        private val POKEMON_ERROR_MSG = "Error finding Pokemon data. Valid IDs range from $MIN_POKEMON_ID - $MAX_POKEMON_ID"
    }
}