package com.simon.dragoneclipse.game_service.model.Board

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "boards")
data class Board(
    @Id
    val name: String,
    val fields: List<HexField>
)
