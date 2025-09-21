package com.simon.dragoneclipse.card_service.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.simon.dragoneclipse.card_service.model.mystling.Mystling
import jakarta.persistence.*

@Entity
data class Card(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val effect: String? = null,

    val passive: String? = null,

    val upgrade: String? = null,

    @Enumerated(EnumType.STRING)
    val rarity: CardRarity,

    @Enumerated(EnumType.STRING)
    val type: CardType,

    @ManyToOne
    @JoinColumn(name = "mystling_name")
    @JsonIgnore
    val mystlingName: Mystling? = null


)