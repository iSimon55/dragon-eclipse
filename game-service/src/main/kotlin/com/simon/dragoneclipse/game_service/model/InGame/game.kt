package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.model.Player.Player
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("games")
data class Game(
    @Id val id: String? = null,
    val player1: Player,
    val player2: Player,
    val board: Board,
    val currentTurnPlayerId: String,
    val status: GameStatus = GameStatus.ONGOING
)

enum class GameStatus {
    ONGOING, FINISHED
}
