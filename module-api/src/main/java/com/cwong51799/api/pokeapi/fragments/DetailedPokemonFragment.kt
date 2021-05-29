package com.cwong51799.api.pokeapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.cwong51799.api.R
import com.cwong51799.api.pokeapi.PokemonType
import com.cwong51799.api.pokeapi.custom_ui.BaseStatsView
import com.cwong51799.api.pokeapi.custom_ui.HeightWeightView
import com.cwong51799.api.pokeapi.custom_ui.TypeListingView
import com.cwong51799.api.pokeapi.sprite_recycler.SpriteRecyclerAdapter
import com.cwong51799.api.pokeapi.viewmodels.PokeAPIViewModel
import kotlinx.android.synthetic.main.detailed_pokemon_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites
import org.w3c.dom.Text

class DetailedPokemonFragment : Fragment() {
    private lateinit var viewModel: PokeAPIViewModel
    private lateinit var spriteAdapter : SpriteRecyclerAdapter
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
        val pokemonIdTV = view.findViewById<TextView>(R.id.pokemonIdTV)
        val heightWeightView = view.findViewById<HeightWeightView>(R.id.heightWeightView)
        val pokemonNameTV = view.findViewById<TextView>(R.id.pokemonNameTV)
        val pokemonTypes = view.findViewById<TypeListingView>(R.id.pokemonTypes)
        val baseStatsView = view.findViewById<BaseStatsView>(R.id.baseStats)
        for (type in pokemon.types.sortedBy { type -> type.slot }) {
            pokemonTypes.addType(convertTypeToEnum(type.type.name))
        }
        baseStatsView.setStats(pokemon.stats.map { stat -> stat.baseStat })
        initRecyclerView(pokemon.sprites)
        pokemonIdTV.text = resources.getString(R.string.poke_id, pokemon.id)
        pokemonNameTV.text = pokemon.name.capitalize()
        heightWeightView.setHeightAndWeight(pokemon.height, pokemon.weight)
    }


    private fun convertTypeToEnum(type : String) : PokemonType {
        return when (type) {
            "normal" -> PokemonType.NORMAL
            "fire" -> PokemonType.FIRE
            "water" -> PokemonType.WATER
            "electric" -> PokemonType.ELECTRIC
            "grass" -> PokemonType.GRASS
            "ice" -> PokemonType.ICE
            "fighting" -> PokemonType.FIGHTING
            "poison" -> PokemonType.POISON
            "ground" -> PokemonType.GROUND
            "flying" -> PokemonType.FLYING
            "psychic" -> PokemonType.PSYCHIC
            "bug" -> PokemonType.BUG
            "rock" -> PokemonType.ROCK
            "ghost" -> PokemonType.GHOST
            "dragon" -> PokemonType.DRAGON
            "dark" -> PokemonType.DARK
            "steel" -> PokemonType.STEEL
            else -> PokemonType.FAIRY
        }
    }

    private fun initRecyclerView(sprites : PokemonSprites) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@DetailedPokemonFragment.context, LinearLayoutManager.HORIZONTAL, false)
            spriteAdapter = SpriteRecyclerAdapter()
            spriteAdapter.submitSprites(sprites)
            adapter = spriteAdapter
        }
    }

    companion object {
        private val TAG = "DetailedPokemonFragment"
        fun newInstance() = DetailedPokemonFragment()
    }



}