package com.simon.dragoneclipse.game_service.service

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.model.Board.HexField
import com.simon.dragoneclipse.game_service.model.Board.SpecialSymbol
import com.simon.dragoneclipse.game_service.repository.board.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun createBoard(board: Board): Board {
        return boardRepository.save(board)
    }

    fun getBoardByName(name: String): Board {
        return boardRepository.findById(name)
            .orElseThrow { IllegalArgumentException("Board not found: $name") }
    }

    fun updateBoard(board: Board): Board {
        return boardRepository.save(board)
    }

    fun deleteBoard(id: String) {
        boardRepository.deleteById(id)
    }

    fun getAllBoards(): List<Board> = boardRepository.findAll()

    fun getFieldWithSpecialSymbol(boardName: String, symbol: SpecialSymbol): HexField = boardRepository.findFieldWithSpecialSymbol(boardName, symbol)
}