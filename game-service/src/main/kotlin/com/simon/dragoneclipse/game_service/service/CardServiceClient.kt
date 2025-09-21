package com.simon.dragoneclipse.game_service.service

import com.simon.dragoneclipse.game_service.model.Player.Card
import com.simon.dragoneclipse.game_service.model.Player.Deck
import com.simon.dragoneclipse.game_service.model.Player.Mystling
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class CardServiceClient(
    private val webClientBuilder: WebClient.Builder
) {
    private val baseUrl = "http://localhost:8080/api" // Replace with your card-service URL

    suspend fun getMystlingByName(name: String): Mystling {
        return webClientBuilder.build()
            .get()
            .uri("$baseUrl/mystlings/{name}", name)
            .retrieve()
            .bodyToMono(Mystling::class.java)
            .awaitSingle()
    }

    suspend fun getDeckByName(name: String): Deck {
        return webClientBuilder.build()
            .get()
            .uri("$baseUrl/decks/{name}", name)
            .retrieve()
            .bodyToMono(Deck::class.java)
            .awaitSingle()
    }

    suspend fun getCardById(id: Long): Card{
        return webClientBuilder.build()
            .get()
            .uri("$baseUrl/cards/{id}", id)
            .retrieve()
            .bodyToMono(Card::class.java)
            .awaitSingle()
    }
}
