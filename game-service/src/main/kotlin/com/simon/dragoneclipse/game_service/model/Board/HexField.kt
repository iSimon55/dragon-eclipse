package com.simon.dragoneclipse.game_service.model.Board

data class HexField(
    val q: Int,
    val r: Int,
    val specialSymbol: SpecialSymbol? = null
)

enum class SpecialSymbol {
    LEAF, FLOWER, UMBRELLA, ONE, TWO, THREE
}


