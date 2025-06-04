package com.simon.dragoneclipse.game_service.model.Player

data class Player(
    val id: String,
    val mystling: Mystling,
    val deck: MutableList<Card>,
    //val hand: MutableMap<Int, Card>,
    //val upgrades: List<Card>,
    //val passive: Card,
    //val energyCrystals: Int = 0,
    //val discardPile: List<Card> = listOf(),
    //val hasUsedAbilityThisTurn: MutableSet<String> = mutableSetOf()
)


