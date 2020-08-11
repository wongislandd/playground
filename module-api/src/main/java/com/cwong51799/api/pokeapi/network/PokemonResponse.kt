//package com.cwong51799.api.pokeapi.network
//
//import com.squareup.moshi.JsonClass
//
//data class NameAndURL(var name: String, var url: String)
//
//data class Ability(var ability: NameAndURL, var is_hidden: Boolean, var slot: Int)
//
//data class GameIndex(var game_index: Int, var version: NameAndURL)
//
//data class VersionDetail(var rarity: Int, var version: NameAndURL)
//
//data class VersionGroupDetail(
//    var level_learned_at: Int,
//    var move_learn_method: NameAndURL,
//    var version_group: NameAndURL
//)
//
//data class HeldItem(var item: NameAndURL, var version_details: List<VersionDetail>)
//
//data class Other(var dream_world : DreamWorld, var official_artwork : OfficialArtwork)
//
//data class OfficialArtwork(var front_default : String?)
//
//data class DreamWorld(var front_default : String?, var front_female : String?)
//
//
//data class Sprite(
//    var back_default: String?,
//    var back_female: String?,
//    var back_shiny: String?,
//    var back_shiny_female: String?,
//    var front_default: String?,
//    var front_female: String?,
//    var front_shiny: String?,
//    var front_shiny_female: String?,
//    var other: Other?,
//    var versions : Obje
//)
//
//data class Move(var move: NameAndURL, var version_group_details)
//
//@JsonClass(generateAdapter = true)
//data class PokemonResponse(
//    var abilities: List<Ability>,
//    var base_experience: Int,
//    var forms: List<NameAndURL>,
//    var game_indices: List<GameIndex>,
//    var height: Int,
//    var held_items: HeldItem,
//    var id: Int,
//    var is_default: Boolean,
//    var location_area_encounters: String,
//    var moves: List<VersionGroupDetail>,
//    var name: String,
//    var order: Int,
//    var species: NameAndURL,
//    var sprites: