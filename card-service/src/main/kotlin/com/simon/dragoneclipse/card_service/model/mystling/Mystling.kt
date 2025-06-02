package com.simon.dragoneclipse.card_service.model.mystling

import com.fasterxml.jackson.annotation.JsonIgnore
import com.simon.dragoneclipse.card_service.model.Card
import jakarta.persistence.*

@Entity
data class Mystling(
    @Id
    val name: String,

    @ManyToOne
    @JoinColumn(name = "type_name")
    val type: MystlingType,

    @OneToMany(mappedBy = "mystling", cascade = [CascadeType.ALL])
    val subType: List<SubType>? = null,

    @OneToMany(mappedBy = "mystling", cascade = [CascadeType.ALL])
    val specialAbility: List<MystlingSpecialAbility>,

    @OneToMany(mappedBy = "mystlingName", cascade = [CascadeType.ALL])
    @JsonIgnore
    val cards: List<Card>,

    val tokens: Int = 0,
    // PvE stats
    val hp: Int,

    val attack: Int,

    val speed: Int,

    val defense: Int,

    val specialDefense: Int,

    // PvP stats
    val hpPvP: Int,

    val attackPvP: Int,

    val speedPvP: Int,

    val defensePvP: Int,

    val specialDefensePvP: Int
)
