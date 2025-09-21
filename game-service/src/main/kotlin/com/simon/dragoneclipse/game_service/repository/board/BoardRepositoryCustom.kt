package com.simon.dragoneclipse.game_service.repository.board

import com.simon.dragoneclipse.game_service.model.Board.HexField
import com.simon.dragoneclipse.game_service.model.Board.SpecialSymbol


interface BoardRepositoryCustom {
    fun findFieldWithSpecialSymbol(boardName: String, symbol: SpecialSymbol): HexField
}
