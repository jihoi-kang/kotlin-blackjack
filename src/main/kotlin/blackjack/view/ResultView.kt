package blackjack.view

import blackjack.domain.card.CardRank
import blackjack.domain.card.CardSuit
import blackjack.domain.participant.Dealer
import blackjack.domain.participant.Participant
import blackjack.domain.participant.Player
import blackjack.domain.result.GameResult

object ResultView {

    fun printStartCards(dealer: Dealer, players: List<Player>) {
        val playerNames = players.joinToString { it.name }

        val startPlayerCardsInfo = players.joinToString("\n") { player ->
            getParticipantInformation(player)
        }

        println(buildString {
            append("${dealer.name}와 ${playerNames}에게 2장의 카드를 나누었습니다.\n")
            append("${getDealerStartCard(dealer)}\n")
            append(startPlayerCardsInfo)
        })
    }

    fun printPlayerInformation(participant: Participant) {
        println(getParticipantInformation(participant))
    }

    fun printParticipantsResult(dealer: Dealer, players: List<Player>) {
        println(buildString {
            append("${getParticipantInformation(dealer)} - 결과: ${dealer.cards.sum()}\n")
            players.forEach { player ->
                append("${getParticipantInformation(player)} - 결과: ${player.cards.sum()}\n")
            }
        })
    }

    fun printGetCardForDealer() {
        println("딜러는 16이하라 한장의 카드를 더 받았습니다.")
    }

    fun printGameResult(gameResult: GameResult) {
        val playersResult = gameResult.playersResult.joinToString(separator = "\n") {
            "${it.player.name}: ${it.profit}"
        }

        println(buildString {
            append("## 최종 수익\n")
            append("${gameResult.dealerName}: ${gameResult.dealerProfit}\n")
            append(playersResult)
        })
    }

    private fun getParticipantInformation(participant: Participant): String {
        return buildString {
            append(participant.name)
            append("카드: ")
            append(participant.cards.cards.joinToString { "${it.rank.name()}${it.suit.name()}" })
        }
    }

    private fun getDealerStartCard(dealer: Dealer): String {
        val firstCard = dealer.cards.cards.first()
        return buildString {
            append(dealer.name)
            append("카드: ")
            append("${firstCard.rank.name()}${firstCard.suit.name()}")
        }
    }

    private fun CardSuit.name(): String = when (this) {
        CardSuit.Diamond -> "다이아몬드"
        CardSuit.Heart -> "하트"
        CardSuit.Spade -> "스페이드"
        CardSuit.Club -> "클로버"
    }

    private fun CardRank.name(): String = when (this) {
        CardRank.Ace -> "A"
        CardRank.Two -> "2"
        CardRank.Three -> "3"
        CardRank.Four -> "4"
        CardRank.Five -> "5"
        CardRank.Six -> "6"
        CardRank.Seven -> "7"
        CardRank.Eight -> "8"
        CardRank.Nine -> "9"
        CardRank.Ten -> "10"
        CardRank.Jack -> "J"
        CardRank.Queen -> "Q"
        CardRank.King -> "k"
    }

}
