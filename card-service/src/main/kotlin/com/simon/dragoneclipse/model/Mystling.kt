package com.simon.dragoneclipse.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Mystling(
    @Id
    val name: String,

    @ManyToOne
    @JoinColumn(name = "type_name")
    val type: MystlingType,

    @OneToMany(mappedBy = "mystling", cascade = [CascadeType.ALL])
    val specialAbility: List<MystlingSpecialAbility>,

    @OneToMany(mappedBy = "mystlingName", cascade = [CascadeType.ALL])
    @JsonIgnore
    val cards: List<Card>,

    // PvE stats
    val hp: Int,

    val attack: Int,

    val speed: Int,

    val defense: Int,

    val specialdefense: Int,

    // PvP stats
    val hpPvP: Int,

    val attackPvP: Int,

    val speedPvP: Int,

    val defensePvP: Int,

    val specialdefensePvP: Int
)
