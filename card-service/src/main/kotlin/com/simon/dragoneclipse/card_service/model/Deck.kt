package com.simon.dragoneclipse.card_service.model
import com.fasterxml.jackson.annotation.JsonIgnore
import com.simon.dragoneclipse.card_service.model.mystling.Mystling
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
data class Deck(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ElementCollection
    @CollectionTable(name = "deck_card_ids", joinColumns = [JoinColumn(name = "deck_id")])
    @Column(name = "card_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    val cardIds: List<Long> = listOf(),

    @ManyToOne
    @JoinColumn(name = "mystling_deck")
    @JsonIgnore // ignorujemy pełny obiekt przy serializacji
    val mystling: Mystling
) {
    // Pole do serializacji tylko nazwy
    val mystlingName: String
        get() = mystling.name
}
