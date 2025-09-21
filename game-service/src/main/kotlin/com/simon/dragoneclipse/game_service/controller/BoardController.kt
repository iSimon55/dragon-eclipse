package com.simon.dragoneclipse.game_service.controller

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/boards")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun createBoard(@RequestBody board: Board): Board = boardService.createBoard(board)

    @GetMapping("/{name}")
    fun getBoard(@PathVariable name: String): Board = boardService.getBoardByName(name)

    @PutMapping
    fun updateBoard(@RequestBody board: Board): Board = boardService.updateBoard(board)

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: String) = boardService.deleteBoard(id)

    @GetMapping
    fun getAllBoards(): List<Board> = boardService.getAllBoards()
}