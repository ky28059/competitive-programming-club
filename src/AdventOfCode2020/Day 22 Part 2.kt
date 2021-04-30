package AdventOfCode2020

import java.util.*


fun main() {
    val (deck1: Queue<Int>, deck2: Queue<Int>) = day22
        .map { it.split(System.lineSeparator()) } // Split via cards
        .map { it.drop(1) } // Drop the "Player 1:" and "Player 2:"
        .map { deck -> deck.map { it.toInt() } } // Map all strings to int
        .map { it.toCollection(LinkedList()) }

    println(recursiveCombat(deck1, deck2, mutableListOf(), mutableListOf()))
}

tailrec fun recursiveCombat(deck1: Queue<Int>, deck2: Queue<Int>, priorDeck1: MutableList<Queue<Int>>, priorDeck2: MutableList<Queue<Int>>): Int {
    for (i in priorDeck1.indices) {
        if (priorDeck1[i] == deck1 && priorDeck2[i] == deck2) return calcDeckScore(deck1, deck1.size, 0)
    }

    // Add current deck configurations to past configurations list
    priorDeck1.add(LinkedList<Int>(deck1))
    priorDeck2.add(LinkedList<Int>(deck2))

    val p1card = deck1.poll() ?: return calcDeckScore(deck2, deck2.size, 0)
    val p2card = deck2.poll() ?: return calcDeckScore(deck1, deck1.size, 0)

    calcRoundWinner(p1card, p2card, deck1, deck2)

    return recursiveCombat(deck1, deck2, priorDeck1, priorDeck2)
}

// A function similar to recursiveCombat, but returns boolean to determine round winners
// True means that player 1 (you) win, while false means that player 2 (the crab) wins
tailrec fun innerRecursiveCombat(deck1: Queue<Int>, deck2: Queue<Int>, priorDeck1: MutableList<Queue<Int>>, priorDeck2: MutableList<Queue<Int>>): Boolean {
    for (i in priorDeck1.indices) {
        if (priorDeck1[i] == deck1 && priorDeck2[i] == deck2) return true
    }

    // Add current deck configurations to past configurations list
    priorDeck1.add(LinkedList<Int>(deck1))
    priorDeck2.add(LinkedList<Int>(deck2))

    val p1card = deck1.poll() ?: return false
    val p2card = deck2.poll() ?: return true

    calcRoundWinner(p1card, p2card, deck1, deck2)

    return innerRecursiveCombat(deck1, deck2, priorDeck1, priorDeck2)
}

// Function to run the logic to calculate the round winner
// Exists so that logic can be reused and also so that innerRecursiveCombat can be tailrec
// and avoid pesky stack overflow
fun calcRoundWinner(p1card: Int, p2card: Int, deck1: Queue<Int>, deck2: Queue<Int>) {
    if (p1card <= deck1.size && p2card <= deck2.size) {
        // Get the next x cards in the queue
        // Do this sloppily via for loops
        val next1 = LinkedList<Int>(deck1); val next2 = LinkedList<Int>(deck2);

        for (i in 0 until deck1.size - p1card) {
            next1.removeLast()
        }
        for (i in 0 until deck2.size - p2card) {
            next2.removeLast()
        }

        // If both players cards are smaller than or equal to their decks,
        // the winner of the round is determined by another game of recursive combat
        if (innerRecursiveCombat(LinkedList<Int>(next1), LinkedList<Int>(next2), mutableListOf(), mutableListOf())) {
            deck1.add(p1card)
            deck1.add(p2card)
        } else {
            deck2.add(p2card)
            deck2.add(p1card)
        }
    } else {
        // Otherwise, the round is decided by higher card like combat
        if (p1card > p2card) {
            deck1.add(p1card)
            deck1.add(p2card)
        } else {
            deck2.add(p2card)
            deck2.add(p1card)
        }
    }
}