package com.simon.dragoneclipse.card_service.controller

import com.simon.dragoneclipse.card_service.dto.CreateDeckRequest
import com.simon.dragoneclipse.card_service.model.Deck
import com.simon.dragoneclipse.card_service.service.DeckService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/decks")
class DeckController(private val deckService: DeckService) {

    @PostMapping
    fun createDeck(@RequestBody request: CreateDeckRequest): ResponseEntity<Deck> {
        val savedDeck = deckService.createDeck(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeck)
    }

    @DeleteMapping("/{id}")
    fun deleteDeck(@PathVariable id: Long): ResponseEntity<Void> {
        deckService.deleteDeck(id)
        return ResponseEntity.noContent().build()
    }
}
