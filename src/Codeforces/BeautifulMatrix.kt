import kotlin.math.abs

private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    for (i in 0 until 5) {
        val row = readInts()

        for (j in 0 until 5) {
            if (row[j] == 1) {
                println(abs(j - 2) + abs(i - 2))
                return
            }
        }
    }
}
