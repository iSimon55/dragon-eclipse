package com.simon.dragoneclipse.model
import com.simon.dragoneclipse.model.mystling.Mystling
import jakarta.persistence.*

@Entity
data class Deck(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToMany
    val cards: List<Card> = listOf(),

    @ManyToOne
    @JoinColumn(name = "mystling_deck")
    val mystling: Mystling
)
