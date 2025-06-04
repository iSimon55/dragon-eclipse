package com.simon.dragoneclipse.game_service.service

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun createBoard(board: Board): Board {
        return boardRepository.save(board)
    }

    fun getBoardById(id: String): Board {
        return boardRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Board not found: $id") }
    }

    fun updateBoard(board: Board): Board {
        return boardRepository.save(board)
    }

    fun deleteBoard(id: String) {
        boardRepository.deleteById(id)
    }

    fun getAllBoards(): List<Board> = boardRepository.findAll()
}