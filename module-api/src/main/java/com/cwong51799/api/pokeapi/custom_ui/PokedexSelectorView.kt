package com.cwong51799.api.pokeapi.custom_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridLayout
import com.cwong51799.api.R

class PokedexSelectorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.fragment_pokedex_selector, this, true)
    }
}