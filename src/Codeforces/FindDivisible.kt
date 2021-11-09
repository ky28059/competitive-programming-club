private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Educational Codeforces Round 57
// Problem A
// For lockout, accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (l, r) = readInts()
        println("$l ${l * 2}")
    }
}
