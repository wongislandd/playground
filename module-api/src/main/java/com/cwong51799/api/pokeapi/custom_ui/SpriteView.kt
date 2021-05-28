package com.cwong51799.api.pokeapi.custom_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import com.bumptech.glide.Glide
import com.cwong51799.api.R
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites

class SpriteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridLayout(context, attrs) {

    private var spriteCarosel : LinearLayout

    init {
        LayoutInflater.from(context).inflate(R.layout.sprite_view, this, true)
        spriteCarosel = findViewById(R.id.sprite_carosel)
    }

    fun addSpritesToCarosel(sprites : PokemonSprites) {
        val spriteUrls = getURLsFromSpritesObject(sprites);
        spriteUrls.forEach { url ->
            var newSprite : ImageView = LayoutInflater.from(context).inflate(R.layout.individual_sprite, null) as ImageView
            context.let { Glide.with(it).load(url).into(newSprite) }
            spriteCarosel.addView(newSprite)
        }
    }

    private fun getURLsFromSpritesObject(sprites : PokemonSprites) : MutableList<String> {
        val validSpritesList : MutableList<String> = mutableListOf()
        sprites.frontDefault?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backDefault?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontShiny?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backShiny?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontShinyFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backShinyFemale?.let { sprite -> validSpritesList.add(sprite)}
        return validSpritesList
    }

}