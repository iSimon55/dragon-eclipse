package com.simon.dragoneclipse.game_service.repository.board

import com.simon.dragoneclipse.game_service.model.Board.Board
import com.simon.dragoneclipse.game_service.model.Board.HexField
import com.simon.dragoneclipse.game_service.model.Board.SpecialSymbol
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class BoardRepositoryCustomImpl(
    private val mongoTemplate: MongoTemplate
) : BoardRepositoryCustom {

    override fun findFieldWithSpecialSymbol(boardName: String, symbol: SpecialSymbol): HexField {
        val query = Query(
            Criteria.where("name").`is`(boardName)
                .and("fields.specialSymbol").`is`(symbol.name)
        )
        query.fields().include("fields.$")

        val board = mongoTemplate.findOne(query, Board::class.java) ?: throw IllegalStateException("Board with name '$boardName' not found")
        val field = board.fields.firstOrNull { it.specialSymbol == symbol }
            ?: throw IllegalStateException("No field with specialSymbol '$symbol' found on board '$boardName'")

        return field
    }
}
