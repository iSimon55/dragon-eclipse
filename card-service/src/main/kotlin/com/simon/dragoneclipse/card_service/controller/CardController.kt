package com.simon.dragoneclipse.card_service.controller

import com.simon.dragoneclipse.card_service.dto.CreateCardRequest
import com.simon.dragoneclipse.card_service.model.Card
import com.simon.dragoneclipse.card_service.service.CardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/cards")
class CardController(private val cardService: CardService) {

    @GetMapping
    fun getAllCards(): List<Card> = cardService.getAllCards()

    @GetMapping("/{id}")
    fun getCardById(@PathVariable id: Long): ResponseEntity<Card> {
        val card = cardService.getCardById(id)
        return if (card != null) ResponseEntity.ok(card)
        else ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

    @PostMapping
    fun createCard(@RequestBody request: CreateCardRequest): ResponseEntity<Card> {
        val savedCard = cardService.createCard(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard)
    }

    @DeleteMapping("/{id}")
    fun deleteCard(@PathVariable id: Long): ResponseEntity<Void> {
        cardService.deleteCard(id)
        return ResponseEntity.noContent().build()
    }
}