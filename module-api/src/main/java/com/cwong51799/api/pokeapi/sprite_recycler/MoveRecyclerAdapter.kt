package com.cwong51799.api.pokeapi.sprite_recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cwong51799.api.R
import kotlinx.android.synthetic.main.individual_sprite.view.*
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites

class MoveRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var spriteUrls : List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SpriteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.individual_sprite, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SpriteViewHolder -> {
                holder.bind(spriteUrls.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return spriteUrls.size
    }

    fun submitSprites(sprites : PokemonSprites) {
        val validSpritesList : MutableList<String> = mutableListOf()
        sprites.frontDefault?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backDefault?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontShiny?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backShiny?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.frontShinyFemale?.let { sprite -> validSpritesList.add(sprite)}
        sprites.backShinyFemale?.let { sprite -> validSpritesList.add(sprite)}
        spriteUrls = validSpritesList
    }

    class SpriteViewHolder constructor(val spriteView : View) : RecyclerView.ViewHolder(spriteView) {
        val spriteImage : ImageView =  spriteView.sprite_image
        fun bind(url : String) {
            Glide.with(spriteView.context).load(url).into(spriteImage)
        }
    }

}