package com.cwong51799.api.pokeapi.sprite_recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cwong51799.api.R
import kotlinx.android.synthetic.main.individual_sprite.view.*
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites

class GameRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var games : List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.individual_game, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GameViewHolder -> {
                holder.bind(games[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun submitGames(games : List<String>) {
        this.games = games
    }

    class GameViewHolder constructor(val gameView : View) : RecyclerView.ViewHolder(gameView) {
        val gameTV = gameView.findViewById<TextView>(R.id.gameEntry)
        fun bind(game : String) {
            gameTV.text = game
        }
    }

}