package com.simon.dragoneclipse.card_service.service

import com.simon.dragoneclipse.card_service.dto.CreateDeckRequest
import com.simon.dragoneclipse.card_service.model.Deck
import com.simon.dragoneclipse.card_service.repository.CardRepository
import com.simon.dragoneclipse.card_service.repository.MystlingRepository
import com.simon.dragoneclipse.card_service.repository.deck.DeckRepository
import org.springframework.stereotype.Service

@Service
class DeckService(
    private val deckRepository: DeckRepository,
    private val cardRepository: CardRepository,
    private val mystlingRepository: MystlingRepository
) {

    fun createDeck(request: CreateDeckRequest): Deck {

        if(request.cardIds.size != 16){
            throw IllegalArgumentException("Invalid number of cards")
        }

        //val cards = cardRepository.findAllById(request.cardIds)

        val mystling = mystlingRepository.findById(request.mystlingName)
            .orElseThrow { IllegalArgumentException("Mystling not found") }

        val deck = Deck(
            name = request.name,
            cardIds = request.cardIds,
            mystling = mystling
        )

        return deckRepository.save(deck)
    }

    fun deleteDeck(id: Long) = deckRepository.deleteById(id)

    fun getDeckByName(name: String) = deckRepository.getDeckByName(name)
}
