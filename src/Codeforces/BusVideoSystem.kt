import java.lang.Integer.max

private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// For lockout, unfinished
fun main() {
    val (n, w) = readInts()
    val stops = readInts()

    var positive = 0
    var negative = 0

    for (i in stops) if (i > 0) positive += i else negative += i
    println(w - max(positive, -negative) + 1)
}
