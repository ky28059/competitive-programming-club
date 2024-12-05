import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Kotlin Heroes Episode 6
// Problem C
// Not submitted (unfinished)
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, posOne, posTwo) = readInts()

        val distOne = if (posOne > posTwo) n - posOne else posOne - 1
        val distTwo = if (posTwo > posOne) n - posTwo else posTwo - 1

        val diff = abs(distOne - distTwo)
        val max = max(distOne, distTwo)

        val left = (n - (diff + 1)) / 2

        println("$max $left")
        println(max + left)
    }
}