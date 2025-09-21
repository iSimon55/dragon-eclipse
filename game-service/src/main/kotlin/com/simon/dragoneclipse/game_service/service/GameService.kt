package com.simon.dragoneclipse.game_service.service

import com.simon.dragoneclipse.game_service.dto.CreateGameRequest
import com.simon.dragoneclipse.game_service.model.Board.SpecialSymbol
import com.simon.dragoneclipse.game_service.model.InGame.*
import com.simon.dragoneclipse.game_service.model.Player.Card
import com.simon.dragoneclipse.game_service.model.Player.Player
import com.simon.dragoneclipse.game_service.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(
    private val gameRepository: GameRepository,
    private val boardService: BoardService,
    private val cardService: CardServiceClient
) {

    // create game - game is not starting yet
    suspend fun createGame(request: CreateGameRequest): Game {
        val board = boardService.getBoardByName(request.boardName)

        val mystling1 = cardService.getMystlingByName(request.player1.mystlingName)
        val deck1 = cardService.getDeckByName(request.player1.deckName)
        val position1 = boardService.getFieldWithSpecialSymbol(request.boardName, SpecialSymbol.ONE)
        val deck1InGame: MutableList<Card> = mutableListOf()
        var card: Card
        for(cardId in deck1.cardIds){
            card = cardService.getCardById(cardId)
            deck1InGame.add(card)
        }

        val mystling2 = cardService.getMystlingByName(request.player2.mystlingName)
        val deck2 = cardService.getDeckByName(request.player2.deckName)
        val position2 = boardService.getFieldWithSpecialSymbol(request.boardName, SpecialSymbol.TWO)
        val deck2InGame: MutableList<Card> = mutableListOf()
        for(cardId in deck2.cardIds){
            card = cardService.getCardById(cardId)
            deck2InGame.add(card)
        }



        val player1InGame = PlayerInGame(
            player = Player(id = request.player1.playerId, mystlingName = mystling1.name, deck = deck1),
            MystlingInGame = MystlingInGame(mystling1, position1),
            //hand = mutableListOf(),
            discardPile = mutableListOf(),
            hasUsedAbilityThisTurn = mutableSetOf(),
            upgrades = mutableListOf(),
            passive = null,
            energyCrystals = 0,
            deckInGame = deck1InGame
        )

        val player2InGame = PlayerInGame(
            player = Player(id = request.player2.playerId, mystlingName = mystling2.name, deck = deck2),
            MystlingInGame = MystlingInGame(mystling2, position2),
            //hand = mutableListOf(),
            discardPile = mutableListOf(),
            hasUsedAbilityThisTurn = mutableSetOf(),
            upgrades = mutableListOf(),
            passive = null,
            energyCrystals = 0,
            deckInGame = deck2InGame
        )

        val game = Game(
            player1 = player1InGame,
            player2 = player2InGame,
            board = board,
            currentTurnPlayerId = request.currentTurnPlayerId,
            status = GameStatus.ONGOING,
            turnPhase = TurnPhase.WAITING_FOR_START
        )

        return gameRepository.save(game)
    }

    //start the game - draw cards, give player2 1 energy
    fun startGame(gameId: String): Game{
        val game = gameRepository.findById(gameId)
            .orElseThrow { IllegalArgumentException("Game not found: $gameId") }


        return game
    }

    fun getGameById(id: String): Game {
        return gameRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Game not found: $id") }
    }

    fun updateGame(game: Game): Game {
        return gameRepository.save(game)
    }

    fun deleteGame(id: String) {
        gameRepository.deleteById(id)
    }

    fun getAllGames(): List<Game> = gameRepository.findAll()


}