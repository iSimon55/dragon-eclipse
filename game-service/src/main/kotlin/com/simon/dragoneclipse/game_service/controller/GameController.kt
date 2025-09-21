package com.simon.dragoneclipse.game_service.controller

import com.simon.dragoneclipse.game_service.dto.CreateGameRequest
import com.simon.dragoneclipse.game_service.model.InGame.Game
import com.simon.dragoneclipse.game_service.service.GameService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = arrayOf("*"))
class GameController(
    private val gameService: GameService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun createGame(@RequestBody request: CreateGameRequest): Game {
        return gameService.createGame(request)
    }

    @GetMapping("/{id}")
    fun getGame(@PathVariable id: String): Game = gameService.getGameById(id)

    @PutMapping
    fun updateGame(@RequestBody game: Game): Game = gameService.updateGame(game)

    @DeleteMapping("/{id}")
    fun deleteGame(@PathVariable id: String) = gameService.deleteGame(id)

    @GetMapping
    fun getAllGames(): List<Game> = gameService.getAllGames()
}