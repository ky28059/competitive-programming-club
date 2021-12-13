package AdventOfCode2020

import java.util.*


fun main() {
    val (deck1: Queue<Int>, deck2: Queue<Int>) = day22
        .map { it.split(System.lineSeparator()) } // Split via cards
        .map { it.drop(1) } // Drop the "Player 1:" and "Player 2:"
        .map { deck -> deck.map { it.toInt() } } // Map all strings to int
        .map { it.toCollection(LinkedList()) }

    println(combat(deck1, deck2))
}

tailrec fun combat(deck1: Queue<Int>, deck2: Queue<Int>): Int {
    val p1card = deck1.poll() ?: return calcDeckScore(deck2)
    val p2card = deck2.poll() ?: return calcDeckScore(deck1)

    if (p1card > p2card) {
        deck1.add(p1card)
        deck1.add(p2card)
    } else {
        deck2.add(p2card)
        deck2.add(p1card)
    }
    return combat(deck1, deck2)
}

tailrec fun calcDeckScore(queue: Queue<Int>, sum: Int = 0): Int {
    val head = queue.poll() ?: return sum
    return calcDeckScore(queue, sum + head * (queue.size + 1))
}
