private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 726
// Problem A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val arr = readInts()
        val sum = arr.sum()

        println(when {
            sum / n.toDouble() == 1.0 -> 0
            sum > n -> sum - n
            else -> 1
        })
    }
}