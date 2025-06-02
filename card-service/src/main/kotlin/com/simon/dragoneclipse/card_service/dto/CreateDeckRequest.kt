package com.simon.dragoneclipse.card_service.dto

data class CreateDeckRequest(
    val name: String,
    val cardIds: List<Long>,
    val mystlingName: String
)