package com.cwong51799.api.pokeapi.custom_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.cwong51799.api.R
import com.cwong51799.api.pokeapi.PokemonType
import com.google.android.flexbox.FlexboxLayout

class TypeListingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridLayout(context, attrs) {

    private var typeList : FlexboxLayout

    init {
        LayoutInflater.from(context).inflate(R.layout.type_listing, this, true)
        typeList = findViewById(R.id.type_listing)
    }

    fun addType(type : PokemonType) {
        var typeView : TextView = LayoutInflater.from(context).inflate(R.layout.pokemon_type, null) as TextView
        setupTypeTextView(typeView, type)
        typeList.addView(typeView)
    }


    fun setupTypeTextView(view : TextView, type : PokemonType) {
        view.text = type.name
        view.background = when (type) {
            PokemonType.BUG -> resources.getDrawable(R.drawable.bug_type_background)
            PokemonType.DARK -> resources.getDrawable(R.drawable.dark_type_background)
            PokemonType.ELECTRIC -> resources.getDrawable(R.drawable.electric_type_background)
            PokemonType.FAIRY -> resources.getDrawable(R.drawable.fairy_type_background)
            PokemonType.FIGHTING -> resources.getDrawable(R.drawable.fighting_type_background)
            PokemonType.FIRE -> resources.getDrawable(R.drawable.fire_type_background)
            PokemonType.FLYING -> resources.getDrawable(R.drawable.flying_type_background)
            PokemonType.GHOST -> resources.getDrawable(R.drawable.ghost_type_background)
            PokemonType.GRASS -> resources.getDrawable(R.drawable.grass_type_background)
            PokemonType.ICE -> resources.getDrawable(R.drawable.ice_type_background)
            PokemonType.NORMAL -> resources.getDrawable(R.drawable.normal_type_background)
            PokemonType.POISON -> resources.getDrawable(R.drawable.poison_type_background)
            PokemonType.PSYCHIC -> resources.getDrawable(R.drawable.psychic_type_background)
            PokemonType.ROCK -> resources.getDrawable(R.drawable.rock_type_background)
            PokemonType.STEEL -> resources.getDrawable(R.drawable.steel_type_background)
            PokemonType.GROUND -> resources.getDrawable(R.drawable.ground_type_background)
            PokemonType.DRAGON -> resources.getDrawable(R.drawable.dragon_type_background)
            else -> resources.getDrawable(R.drawable.water_type_background)
        }
    }

}