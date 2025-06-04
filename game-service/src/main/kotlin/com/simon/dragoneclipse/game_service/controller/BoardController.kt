package com.simon.dragoneclipse.game_service.controller

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/boards")
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun createBoard(@RequestBody Board: Board): Board = boardService.createBoard(Board)

    @GetMapping("/{id}")
    fun getBoard(@PathVariable id: String): Board = boardService.getBoardById(id)

    @PutMapping
    fun updateBoard(@RequestBody Board: Board): Board = boardService.updateBoard(Board)

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: String) = boardService.deleteBoard(id)

    @GetMapping
    fun getAllBoards(): List<Board> = boardService.getAllBoards()
}