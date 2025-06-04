package com.simon.dragoneclipse.game_service.repository

import com.simon.dragoneclipse.game_service.model.InGame.Game
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface GameRepository : MongoRepository<Game, String>