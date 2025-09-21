package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Board.Board
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("games")
data class Game(
    @Id val id: String? = null,
    val player1: PlayerInGame,
    val player2: PlayerInGame,
    val board: Board,
    var currentTurnPlayerId: String,
    var status: GameStatus = GameStatus.ONGOING,
    var turnPhase: TurnPhase
)

enum class GameStatus {
    ONGOING, FINISHED
}
enum class TurnPhase {
    SPECIALS_BEFORE,
    CARD_PLAY,
    SPECIALS_AFTER,
    WAITING_FOR_START
}