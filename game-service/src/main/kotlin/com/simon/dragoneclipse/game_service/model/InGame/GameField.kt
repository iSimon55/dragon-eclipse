package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Board.HexField

data class GameField(
    val field: HexField,
    val tokenPlayer1: Boolean,
    val tokenPlayer2: Boolean,
    val playerId: String? = null // Gracz zajmujący pole
)
