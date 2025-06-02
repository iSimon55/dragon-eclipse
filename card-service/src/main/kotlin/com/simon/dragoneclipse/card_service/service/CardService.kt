package com.simon.dragoneclipse.card_service.service

import com.simon.dragoneclipse.card_service.dto.CreateCardRequest
import com.simon.dragoneclipse.card_service.model.Card
import com.simon.dragoneclipse.card_service.model.mystling.Mystling
import com.simon.dragoneclipse.card_service.repository.CardRepository
import com.simon.dragoneclipse.card_service.repository.MystlingRepository
import org.springframework.stereotype.Service

@Service
class CardService(private val cardRepository: CardRepository, private val mystlingRepository: MystlingRepository) {

    fun getAllCards(): List<Card> = cardRepository.findAll()

    fun getCardById(id: Long): Card? = cardRepository.findById(id).orElse(null)

    fun createCard(request: CreateCardRequest): Card {
        var mystling: Mystling? = null
        if(!request.mystlingName.isNullOrBlank()){
            mystling = mystlingRepository.findById(request.mystlingName)
                .orElseThrow { IllegalArgumentException("Mystling not found") }
        }
        val card = Card(
            name = request.name,
            effect = request.effect,
            passive = request.passive,
            upgrade = request.upgrade,
            type = request.type,
            mystlingName = mystling,
            rarity = request.rarity
        )
        return cardRepository.save(card)
    }

    fun deleteCard(id: Long) = cardRepository.deleteById(id)
}