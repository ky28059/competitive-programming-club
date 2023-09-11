package AdventOfCode2020

import kotlin.collections.ArrayDeque


fun main() {
    val (deck1, deck2) = day22
        .map { it.split(System.lineSeparator()) } // Split via cards
        .map { it.drop(1) } // Drop the "Player 1:" and "Player 2:"
        .map { deck -> deck.map { it.toInt() } } // Map all strings to int
        .map { ArrayDeque(it) }

    println(recursiveCombat(deck1, deck2))
}

tailrec fun recursiveCombat(
    deck1: ArrayDeque<Int>,
    deck2: ArrayDeque<Int>,
    priorDeck1: MutableList<ArrayDeque<Int>> = mutableListOf(),
    priorDeck2: MutableList<ArrayDeque<Int>> = mutableListOf()
): Int {
    for (i in priorDeck1.indices) {
        if (priorDeck1[i] == deck1 && priorDeck2[i] == deck2) return calcDeckScore(deck1)
    }

    // Add current deck configurations to past configurations list
    priorDeck1.add(ArrayDeque(deck1))
    priorDeck2.add(ArrayDeque(deck2))

    val p1card = deck1.removeFirstOrNull() ?: return calcDeckScore(deck2)
    val p2card = deck2.removeFirstOrNull() ?: return calcDeckScore(deck1)

    calcRoundWinner(p1card, p2card, deck1, deck2)

    return recursiveCombat(deck1, deck2, priorDeck1, priorDeck2)
}

// A function similar to recursiveCombat, but returns boolean to determine round winners
// True means that player 1 (you) win, while false means that player 2 (the crab) wins
tailrec fun innerRecursiveCombat(
    deck1: ArrayDeque<Int>,
    deck2: ArrayDeque<Int>,
    priorDeck1: MutableList<ArrayDeque<Int>> = mutableListOf(),
    priorDeck2: MutableList<ArrayDeque<Int>> = mutableListOf()
): Boolean {
    for (i in priorDeck1.indices) {
        if (priorDeck1[i] == deck1 && priorDeck2[i] == deck2) return true
    }

    // Add current deck configurations to past configurations list
    priorDeck1.add(ArrayDeque(deck1))
    priorDeck2.add(ArrayDeque(deck2))

    val p1card = deck1.removeFirstOrNull() ?: return false
    val p2card = deck2.removeFirstOrNull() ?: return true

    calcRoundWinner(p1card, p2card, deck1, deck2)

    return innerRecursiveCombat(deck1, deck2, priorDeck1, priorDeck2)
}

// Function to run the logic to calculate the round winner
// Exists so that logic can be reused and also so that innerRecursiveCombat can be tailrec
// and avoid pesky stack overflow
fun calcRoundWinner(p1card: Int, p2card: Int, deck1: ArrayDeque<Int>, deck2: ArrayDeque<Int>) {
    if (p1card <= deck1.size && p2card <= deck2.size) {
        // Get the next x cards in the queue
        val next1 = deck1.toList().dropLast(deck1.size - p1card)
        val next2 = deck2.toList().dropLast(deck2.size - p2card)

        // If both players cards are smaller than or equal to their decks,
        // the winner of the round is determined by another game of recursive combat
        if (innerRecursiveCombat(ArrayDeque(next1), ArrayDeque(next2))) {
            deck1.add(p1card)
            deck1.add(p2card)
        } else {
            deck2.add(p2card)
            deck2.add(p1card)
        }
    } else if (p1card > p2card) { // Otherwise, the round is decided by higher card like combat
        deck1.add(p1card)
        deck1.add(p2card)
    } else {
        deck2.add(p2card)
        deck2.add(p1card)
    }
}
