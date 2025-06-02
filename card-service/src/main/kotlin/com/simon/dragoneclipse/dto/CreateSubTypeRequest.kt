package com.simon.dragoneclipse.dto

import com.simon.dragoneclipse.model.mystling.MystlingTypeName

data class CreateSubTypeRequest(
    val type: MystlingTypeName,
    val cards: Int? = null,
    val tokens: Int? = null
)

