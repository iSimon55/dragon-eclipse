package com.simon.dragoneclipse.dto

import com.simon.dragoneclipse.model.CardRarity
import com.simon.dragoneclipse.model.CardType
import com.simon.dragoneclipse.model.Mystling

data class CreateCardRequest(
    val name: String,
    val effect: String? = null,
    val type: CardType = CardType.NEUTRAL,
    val passive: String? = null,
    val upgrade: String? = null,
    val mystlingName: Mystling? = null,
    val rarity: CardRarity = CardRarity.COMMON
)