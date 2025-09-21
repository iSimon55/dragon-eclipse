package com.simon.dragoneclipse.game_service.model.Player

data class Card(
    val id: Long,
    val name: String,
    val type: CardType,
    val effect: String,
    val passive: String? = null,
    val upgrade: String? = null,
    val rarity: CardRarity,
    //val mystlingName: Mystling? = null
    //val range: Int? = null,
    //val cost: Int = 0
)

enum class CardType {
    FIRE,
    WATER,
    EARTH,
    WIND,
    LIGHT,
    DARK,
    NEUTRAL
}
enum class CardRarity {
    COMMON,
    RARE,
    ULTRA_RARE,
    LEGENDARY,
    MYSTLING
}