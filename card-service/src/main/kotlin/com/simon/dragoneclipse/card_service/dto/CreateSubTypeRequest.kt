package com.simon.dragoneclipse.card_service.dto

import com.simon.dragoneclipse.card_service.model.mystling.MystlingTypeName

data class CreateSubTypeRequest(
    val type: MystlingTypeName,
    val cards: Int? = null,
    val tokens: Int? = null
)

