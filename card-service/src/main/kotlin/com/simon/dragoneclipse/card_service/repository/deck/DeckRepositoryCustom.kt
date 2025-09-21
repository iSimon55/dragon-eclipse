package com.simon.dragoneclipse.card_service.repository.deck

import com.simon.dragoneclipse.card_service.model.Deck

interface DeckRepositoryCustom {
    fun getDeckByName(name: String): Deck?
}