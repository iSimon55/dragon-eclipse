package com.simon.dragoneclipse.game_service.model.Player

data class Mystling(
    val name: String,
    val type: MystlingType,

    var hp: Int,
    var attack: Int,
    var speed: Int,
    var defense: Int,
    var specialDefense: Int,

    var hpPvP: Int,
    var attackPvP: Int,
    var speedPvP: Int,
    var defensePvP: Int,
    var specialDefensePvP: Int,

    val specialAbility: List<MystlingSpecialAbility>,
    val subType: List<MystlingSubType>
)

data class MystlingSpecialAbility(
    val name: String,

    val cost: Int,

    val effect: String
)

data class  MystlingSubType(
    val id: MystlingSubTypeId,
    val tokens: Int,
    val cards: Int
)
data class MystlingSubTypeId(
    val mystlingName: String,
    val type: MystlingTypeName
)

enum class MystlingTypeName {
    FIRE,
    WATER,
    EARTH,
    WIND,
    LIGHT,
    DARK
}

data class MystlingType(
    val name: MystlingTypeName,

    val skillName: String,

    val cost: Int,

    val effect: String
)