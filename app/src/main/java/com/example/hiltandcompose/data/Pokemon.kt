package com.example.hiltandcompose.data

data class Pokemon(
    val abilities: List<Ability> = listOf(),
    val base_experience: Int = 0,
    val forms: List<Form> = listOf(),
    val game_indices: List<GameIndice> = listOf(),
    val height: Int = 0,
    val held_items: List<HeldItem> = listOf(),
    val id: Int = 0,
    val is_default: Boolean = false,
    val location_area_encounters: String = "",
    val moves: List<Move> = listOf(),
    val name: String = "",
    val order: Int = 0,
    val species: Species = Species(),
    val sprites: Sprites = Sprites(),
    val stats: List<Stat> = listOf(),
    val types: List<Type> = listOf(),
    val weight: Int = 0
)

data class Ability(
    val ability: Ability? = Ability(),
    val is_hidden: Boolean = false,
    val slot: Int = 0
)

data class Form(
    val name: String = "",
    val url: String = ""
)

data class GameIndice(
    val game_index: Int = 0,
    val version: Version = Version()
)

data class HeldItem(
    val item: Item = Item(),
    val version_details: List<VersionDetail> = listOf()
)

data class Move(
    val move: Move? = Move(),
    val version_group_details: List<VersionGroupDetail> = listOf()
)

data class Species(
    val name: String = "",
    val url: String = ""
)

data class Sprites(
    val back_default: String = "",
    val back_female: String = "",
    val back_shiny: String = "",
    val back_shiny_female: String = "",
    val front_default: String = "",
    val front_female: String = "",
    val front_shiny: String = "",
    val front_shiny_female: String = "",
)

data class Stat(
    val base_stat: Int = 0,
    val effort: Int = 0,
    val stat: Stat? = Stat()
)

data class Type(
    val slot: Int = 0,
    val type: Type? = Type()
)

data class Version(
    val name: String = "",
    val url: String = ""
)

data class Item(
    val name: String = "",
    val url: String = ""
)

data class VersionDetail(
    val rarity: Int = 0,
    val version: Version = Version()
)

data class VersionGroupDetail(
    val level_learned_at: Int = 0,
    val move_learn_method: MoveLearnMethod = MoveLearnMethod(),
    val version_group: VersionGroup = VersionGroup()
)

data class MoveLearnMethod(
    val name: String = "",
    val url: String = ""
)

data class VersionGroup(
    val name: String = "",
    val url: String = ""
)
