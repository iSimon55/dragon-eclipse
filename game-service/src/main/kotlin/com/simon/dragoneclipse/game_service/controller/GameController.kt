package com.simon.dragoneclipse.game_service.controller

import com.simon.dragoneclipse.game_service.model.InGame.Game
import com.simon.dragoneclipse.game_service.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
class GameController(
    private val gameService: GameService
) {

    @PostMapping
    fun createGame(@RequestBody game: Game): Game = gameService.createGame(game)

    @GetMapping("/{id}")
    fun getGame(@PathVariable id: String): Game = gameService.getGameById(id)

    @PutMapping
    fun updateGame(@RequestBody game: Game): Game = gameService.updateGame(game)

    @DeleteMapping("/{id}")
    fun deleteGame(@PathVariable id: String) = gameService.deleteGame(id)

    @GetMapping
    fun getAllGames(): List<Game> = gameService.getAllGames()
}