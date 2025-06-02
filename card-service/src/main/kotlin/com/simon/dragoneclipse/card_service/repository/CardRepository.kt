package com.simon.dragoneclipse.card_service.repository

import com.simon.dragoneclipse.card_service.model.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long>
