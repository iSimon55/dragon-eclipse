package com.simon.dragoneclipse.game_service.model.InGame

import com.simon.dragoneclipse.game_service.model.Player.Mystling

data class MystlingInGame(
    val mystling: Mystling,

    var position: Position,
    var weak: Boolean,
    var silence: Boolean,
    var slow: Boolean,
    var burn: Int = 0,
    var tokens: Int = 0,

    var currHp: Int = mystling.hp,
    var attackModifier: Int = 0,
    var speedModifier: Int = 0,
    var defenseModifier: Int = 0,
    var specialDefenseModifier: Int = 0
)
