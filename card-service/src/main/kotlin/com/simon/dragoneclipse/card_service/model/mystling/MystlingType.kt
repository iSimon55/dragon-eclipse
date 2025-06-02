package com.simon.dragoneclipse.card_service.model.mystling

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class MystlingType (

    @Id
    @Enumerated(EnumType.STRING)
    val name: MystlingTypeName,

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    val mystlings: List<Mystling> = listOf(),

    val skillName: String,

    val cost: Int,

    val effect: String
)