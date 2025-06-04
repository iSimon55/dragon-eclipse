package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Player.Card
import com.simon.dragoneclipse.game_service.model.Player.Mystling
import com.simon.dragoneclipse.game_service.model.Player.Player

data class PlayerInGame(
    val player: Player,

    val MystlingInGame: MystlingInGame,

    val hand: MutableMap<Int, Card>,
    val discardPile: MutableList<Card> = mutableListOf(),
    val hasUsedAbilityThisTurn: MutableSet<String> = mutableSetOf(),

    val upgrades: MutableList<Card> = mutableListOf(),
    var passive: Card,
    var energyCrystals: Int = 0
)
