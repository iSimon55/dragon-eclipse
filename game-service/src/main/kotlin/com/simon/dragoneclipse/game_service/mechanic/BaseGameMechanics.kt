package com.simon.dragoneclipse.game_service.mechanic

import com.simon.dragoneclipse.game_service.model.InGame.PlayerInGame

class BaseGameMechanics {
    fun drawFirstHand(player1: PlayerInGame, ) {
        return
    }



    fun moveCardsToEnd(player: PlayerInGame): Boolean {
        val cardsInOrder = player.hand
            .sortedBy { it.slotNumber }
            .mapNotNull { it.card }
            .toMutableList()

        player.hand.forEach { it.card = null }

        for (i in 0 until cardsInOrder.size) {
            player.hand[player.hand.size - i].card = cardsInOrder.removeAt(cardsInOrder.size - 1)
        }
        return true
    }

    fun drawCard(player: PlayerInGame): Boolean {
        if (player.deckInGame.isEmpty()) {
            return false // lub inna logika obsługi pustej talii
        }

        moveCardsToEnd(player)

        val randomIndex = player.deckInGame.indices.random()
        val card = player.deckInGame.removeAt(randomIndex)
        val emptySlot = player.hand.lastOrNull() { it.card == null }
        return if (emptySlot != null) {
            emptySlot.card = card  // modyfikacja oryginalnego obiektu
            true
        } else {
            false
        }
    }
}