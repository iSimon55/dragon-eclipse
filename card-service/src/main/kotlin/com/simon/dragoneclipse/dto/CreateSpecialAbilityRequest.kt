package com.simon.dragoneclipse.dto

import com.simon.dragoneclipse.model.mystling.Mystling

data class CreateSpecialAbilityRequest(
    val name: String,
    //val mystling: Mystling,
    val cost: Int,
    val effect: String
)
