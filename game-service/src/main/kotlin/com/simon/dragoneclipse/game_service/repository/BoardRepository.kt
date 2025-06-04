package com.simon.dragoneclipse.game_service.repository

import com.simon.dragoneclipse.game_service.model.Board.Board
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository: MongoRepository<Board, String>