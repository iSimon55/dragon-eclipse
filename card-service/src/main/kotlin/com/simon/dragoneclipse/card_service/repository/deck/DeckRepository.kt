package com.simon.dragoneclipse.card_service.repository.deck

import com.simon.dragoneclipse.card_service.model.Deck
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckRepository : JpaRepository<Deck, Long>, DeckRepositoryCustom
