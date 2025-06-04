package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Player.Card

data class CardSlot(
    val slotNumber: Int,
    val card: Card?
)
