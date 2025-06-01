package com.simon.dragoneclipse.repository

import com.simon.dragoneclipse.model.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long>
