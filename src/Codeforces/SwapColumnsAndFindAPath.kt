import kotlin.math.max
import kotlin.math.min

private fun readInt() = readln().toInt()
private fun readStrings() = readln().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

// Codeforces Round 990
// Problem A
// Post contest, accepted
fun main() {
    val t = readInt()

    for (j in 0 until t) {
        val n = readInt()
        val first = readInts()
        val second = readInts()

        var sum = 0
        var maxOther = min(first[0], second[0])

        // The maximum path is obtained by the summing the larger value in each column, plus the max of the values
        // not chosen (traversed when we cross from top to bottom).
        for (i in first.indices) {
            sum += if (first[i] > second[i]) first[i] else second[i]
            maxOther = max(
                maxOther,
                if (first[i] > second[i]) second[i] else first[i]
            )
        }

        println(sum + maxOther)
    }
}
