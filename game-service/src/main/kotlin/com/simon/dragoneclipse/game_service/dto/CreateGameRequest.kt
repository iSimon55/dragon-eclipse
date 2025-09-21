package com.simon.dragoneclipse.game_service.dto

data class CreateGameRequest(
    val player1: PlayerReference,
    val player2: PlayerReference,
    val boardName: String,
    val currentTurnPlayerId: String
)

data class PlayerReference(
    val playerId: String,
    val mystlingName: String,
    val deckName: String
)
