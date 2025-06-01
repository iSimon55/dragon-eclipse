package com.simon.dragoneclipse.repository

import com.simon.dragoneclipse.model.Deck
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckRepository : JpaRepository<Deck, Long>
