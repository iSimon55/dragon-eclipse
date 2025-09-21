package com.simon.dragoneclipse.card_service.repository.deck

import com.simon.dragoneclipse.card_service.model.Deck
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class DeckRepositoryCustomImpl(
    @PersistenceContext private val entityManager: EntityManager
) : DeckRepositoryCustom {

    override fun getDeckByName(name: String): Deck {
        return entityManager.createQuery(
            "SELECT d FROM Deck d WHERE d.name = :name",
            Deck::class.java
        )
            .setParameter("name", name)
            .singleResult
    }
}