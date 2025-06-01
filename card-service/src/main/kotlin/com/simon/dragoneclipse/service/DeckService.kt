package com.simon.dragoneclipse.service

import com.simon.dragoneclipse.dto.CreateDeckRequest
import com.simon.dragoneclipse.model.Deck
import com.simon.dragoneclipse.repository.CardRepository
import com.simon.dragoneclipse.repository.DeckRepository
import com.simon.dragoneclipse.repository.MystlingRepository
import org.springframework.stereotype.Service

@Service
class DeckService(
    private val deckRepository: DeckRepository,
    private val cardRepository: CardRepository,
    private val mystlingRepository: MystlingRepository
) {

    fun createDeck(request: CreateDeckRequest): Deck {
        val cards = cardRepository.findAllById(request.cardIds)
        val mystling = mystlingRepository.findById(request.mystlingName)
            .orElseThrow { IllegalArgumentException("Mystling not found") }

        val deck = Deck(
            name = request.name,
            cards = cards,
            mystling = mystling
        )

        return deckRepository.save(deck)
    }

    fun deleteDeck(id: Long) = deckRepository.deleteById(id)
}
