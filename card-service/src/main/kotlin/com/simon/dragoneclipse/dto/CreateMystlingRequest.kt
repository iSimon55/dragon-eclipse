package com.simon.dragoneclipse.dto

import com.simon.dragoneclipse.model.mystling.MystlingSpecialAbility
import com.simon.dragoneclipse.model.mystling.MystlingType
import com.simon.dragoneclipse.model.mystling.MystlingTypeName
import com.simon.dragoneclipse.model.mystling.SubType

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
