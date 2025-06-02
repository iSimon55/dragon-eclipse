package com.simon.dragoneclipse.card_service.dto

import com.simon.dragoneclipse.card_service.model.mystling.MystlingTypeName

data class CreateMystlingRequest(
    val name: String,
    val type: MystlingTypeName,
    val subType: List<CreateSubTypeRequest>? = null,
    val specialAbility: List<CreateSpecialAbilityRequest>,
    val tokens: Int = 0,
    val hp: Int,
    val attack: Int,
    val speed: Int,
    val defense: Int,
    val specialDefense: Int,
    val hpPvP: Int,
    val attackPvP: Int,
    val speedPvP: Int,
    val defensePvP: Int,
    val specialDefensePvP: Int
)
