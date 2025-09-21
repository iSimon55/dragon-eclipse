package com.simon.dragoneclipse.card_service.model

import jakarta.persistence.*

@Entity
data class DeckCard(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "deck_id")
    var deck: Deck,

    @ManyToOne
    @JoinColumn(name = "card_id")
    val card: Card,

    val quantity: Int = 1
)