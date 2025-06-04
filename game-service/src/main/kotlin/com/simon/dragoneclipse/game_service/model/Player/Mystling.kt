package com.simon.dragoneclipse.game_service.model.Player

data class Mystling(
    val name: String,
    val type: MystlingTypeName,

    var hp: Int,
    var attack: Int,
    var speed: Int,
    var defense: Int,
    var specialDefense: Int,

    val specialAbilities: List<MystlingSpecialAbility>,
    val subTypes: List<MystlingSubType>
)

data class MystlingSpecialAbility(
    val name: String,

    val cost: Int,

    val effect: String
)

data class  MystlingSubType(
    val type: MystlingTypeName,
    val tokens: Int
)

enum class MystlingTypeName {
    FIRE,
    WATER,
    EARTH,
    WIND,
    LIGHT,
    DARK
}