package com.simon.dragoneclipse.game_service.service

import com.simon.dragoneclipse.game_service.model.InGame.Game
import com.simon.dragoneclipse.game_service.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(
    private val gameRepository: GameRepository
) {

    fun createGame(game: Game): Game {
        return gameRepository.save(game)
    }

    fun getGameById(id: String): Game {
        return gameRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Game not found: $id") }
    }

    fun updateGame(game: Game): Game {
        return gameRepository.save(game)
    }

    fun deleteGame(id: String) {
        gameRepository.deleteById(id)
    }

    fun getAllGames(): List<Game> = gameRepository.findAll()
}