package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Player.Card
import com.simon.dragoneclipse.game_service.model.Player.Player

data class PlayerInGame(
    val player: Player,

    val MystlingInGame: MystlingInGame,

    val deckInGame: MutableList<Card>,
    val hand: MutableList<CardSlot> = MutableList(4) { index -> CardSlot(slotNumber = index + 1, card = null) },

    val discardPile: MutableList<Card> = mutableListOf(),
    val hasUsedAbilityThisTurn: MutableSet<String> = mutableSetOf(),

    val upgrades: MutableList<Card> = mutableListOf(),
    var passive: Card? = null,
    var energyCrystals: Int = 0
)
