package AdventOfCode2020

import kotlin.collections.ArrayDeque


fun main() {
    val (deck1, deck2) = day22
        .map { it.split(System.lineSeparator()) } // Split via cards
        .map { it.drop(1) } // Drop the "Player 1:" and "Player 2:"
        .map { deck -> deck.map { it.toInt() } } // Map all strings to int
        .map { ArrayDeque(it) }

    println(combat(deck1, deck2))
}

tailrec fun combat(deck1: ArrayDeque<Int>, deck2: ArrayDeque<Int>): Int {
    val p1card = deck1.removeFirstOrNull() ?: return calcDeckScore(deck2)
    val p2card = deck2.removeFirstOrNull() ?: return calcDeckScore(deck1)

    if (p1card > p2card) {
        deck1.add(p1card)
        deck1.add(p2card)
    } else {
        deck2.add(p2card)
        deck2.add(p1card)
    }
    return combat(deck1, deck2)
}

tailrec fun calcDeckScore(queue: ArrayDeque<Int>, sum: Int = 0): Int {
    val head = queue.removeFirstOrNull() ?: return sum
    return calcDeckScore(queue, sum + head * (queue.size + 1))
}
