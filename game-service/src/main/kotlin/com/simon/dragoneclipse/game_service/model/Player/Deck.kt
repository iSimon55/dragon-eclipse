package com.simon.dragoneclipse.game_service.model.Player

data class Deck(
    val id: String,
    val name: String,
    val cardIds: MutableList<Long>,
    val mystlingName: String
)
