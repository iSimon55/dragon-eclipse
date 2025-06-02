package com.simon.dragoneclipse.card_service.dto

data class CreateSpecialAbilityRequest(
    val name: String,
    //val mystling: Mystling,
    val cost: Int,
    val effect: String
)
