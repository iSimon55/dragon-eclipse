package com.simon.dragoneclipse.dto

data class CreateDeckRequest(
    val name: String,
    val cardIds: List<Long>,
    val mystlingName: String
)