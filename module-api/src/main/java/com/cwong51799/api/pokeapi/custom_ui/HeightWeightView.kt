package com.cwong51799.api.pokeapi.custom_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.TextView
import com.cwong51799.api.R

class HeightWeightView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridLayout(context, attrs) {

    private var heightTV : TextView
    private var weightTV : TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.height_weight, this, true)
        heightTV = findViewById(R.id.pokeHeightTV)
        weightTV = findViewById(R.id.pokeWeightTV)
    }

    fun setHeightAndWeight(height : Int = 0, weight : Int = 0) {
        heightTV.text = resources.getString(R.string.poke_height, height)
        weightTV.text = resources.getString(R.string.poke_weight, weight)
    }
}