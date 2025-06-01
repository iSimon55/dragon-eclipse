package com.simon.dragoneclipse.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class MystlingType (

    @Id
    val name: String,

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    val mystlings: List<Mystling> = listOf(),

    val cost: Int,

    val effect: String
)