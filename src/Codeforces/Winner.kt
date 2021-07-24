private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings

// Codeforces Beta Round 2
// Problem A
// Accepted
fun main() {
    val n = readInt()
    val turns = Array(n) { "" to 0 }
    val scores = mutableMapOf<String, Int>()

    for (i in 0 until n) {
        val (name, value) = readStrings()
        val score = value.toInt()
        turns[i] = name to score

        scores[name] = (scores[name] ?: 0) + score
    }

    val max = scores.maxByOrNull { it.value }!!
    val winners = scores.filter { it.value == max.value }.keys
    var name = max.key

    // If there's a tie, resolve it
    // not clean
    if (winners.size > 1) {
        val newScores = mutableMapOf<String, Int>()
        for (i in turns) {
            newScores[i.first] = (newScores[i.first] ?: 0) + i.second
            if (newScores[i.first]!! >= max.value && i.first in winners) {
                name = i.first
                break
            }
        }
    }

    println(name)
}
