package com.simon.dragoneclipse.card_service.model.mystling

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class MystlingSpecialAbility(

    @Id
    val name: String,

    @ManyToOne
    @JoinColumn(name = "mystling_name")
    @JsonIgnore
    val mystling: Mystling,

    val cost: Int,

    val effect: String
)
