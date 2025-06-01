package com.simon.dragoneclipse.service

import com.simon.dragoneclipse.dto.CreateCardRequest
import com.simon.dragoneclipse.model.Card
import com.simon.dragoneclipse.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardService(private val cardRepository: CardRepository) {

    fun getAllCards(): List<Card> = cardRepository.findAll()

    fun getCardById(id: Long): Card? = cardRepository.findById(id).orElse(null)

    fun createCard(request: CreateCardRequest): Card {
        val card = Card(
            name = request.name,
            effect = request.effect,
            passive = request.passive,
            upgrade = request.upgrade,
            type = request.type,
            mystlingName = request.mystlingName,
            rarity = request.rarity
        )
        return cardRepository.save(card)
    }

    fun deleteCard(id: Long) = cardRepository.deleteById(id)
}