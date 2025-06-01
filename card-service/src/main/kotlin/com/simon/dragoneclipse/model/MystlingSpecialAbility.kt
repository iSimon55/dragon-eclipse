package com.simon.dragoneclipse.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

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
