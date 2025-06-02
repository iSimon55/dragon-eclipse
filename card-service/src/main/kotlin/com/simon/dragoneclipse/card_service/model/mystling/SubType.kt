package com.simon.dragoneclipse.card_service.model.mystling

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
data class SubType(
    @EmbeddedId
    val id: SubTypeId,

    @ManyToOne
    @MapsId("mystlingName")
    @JoinColumn(name = "mystling_name")
    @JsonIgnore
    val mystling: Mystling,

    val cards: Int? = null,
    val tokens: Int? = null
)

@Embeddable
data class SubTypeId(
    val mystlingName: String,

    @Enumerated(EnumType.STRING)
    val type: MystlingTypeName
) : Serializable

