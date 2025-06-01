package com.simon.dragoneclipse.controller

import com.simon.dragoneclipse.dto.CreateDeckRequest
import com.simon.dragoneclipse.model.Deck
import com.simon.dragoneclipse.service.DeckService
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
