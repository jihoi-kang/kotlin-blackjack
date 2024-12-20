package blackjack.domain.card

data class Cards(
    private val _cards: MutableList<Card> = mutableListOf(),
) {
    val cards: List<Card>
        get() = _cards.toList()

    fun add(card: Card) {
        _cards.add(card)
    }

    fun sum(): Int {
        var totalSum = cards.filter { it.rank != CardRank.Ace }.sumOf { it.rank.value }

        cards.filter { it.rank == CardRank.Ace }.forEach {
            totalSum += getAceValue(it.rank as CardRank.Ace, totalSum)
        }

        return totalSum
    }

    fun isBusted(): Boolean = sum() > BLACKJACK_SUM

    fun isTwoCardBlackjack(): Boolean = cards.size == 2 && sum() == BLACKJACK_SUM

    fun isBlackjack(): Boolean = sum() == BLACKJACK_SUM

    private fun getAceValue(ace: CardRank.Ace, currentSum: Int): Int {
        return if (currentSum + ace.toEleven() <= BLACKJACK_SUM) {
            ace.toEleven()
        } else {
            ace.value
        }
    }

    companion object {
        private const val BLACKJACK_SUM = 21
    }

}
