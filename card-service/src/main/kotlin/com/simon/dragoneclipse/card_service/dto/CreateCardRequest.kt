package com.simon.dragoneclipse.card_service.dto

import com.simon.dragoneclipse.card_service.model.CardRarity
import com.simon.dragoneclipse.card_service.model.CardType

data class CreateCardRequest(
    val name: String,
    val effect: String? = null,
    val type: CardType = CardType.NEUTRAL,
    val passive: String? = null,
    val upgrade: String? = null,
    val mystlingName: String? = null,
    val rarity: CardRarity = CardRarity.COMMON
)