private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Kotlin Heroes Episode 6
// Question A
// Verdict: Passed
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (x, y) = readInts()

        val remainder = y % x
        var ones = (y - remainder) / x
        var greater = 0

        // Meh code
        while (ones >= 10) {
            val rem = ones % 10
            greater += rem
            ones = (ones - rem) / 10
        }

        println(remainder + ones + greater)
    }
}