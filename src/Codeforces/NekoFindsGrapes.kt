import kotlin.math.min

private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 554
// Problem A
// Post contest for lockout, accepted
fun main() {
    val (n, m) = readInts()
    val chests = readInts()
    val keys = readInts()

    val oddChests = chests.filter { it % 2 == 1 }
    val oddKeys = keys.filter { it % 2 == 1 }
    println(min(oddKeys.size, chests.size - oddChests.size) + min(oddChests.size, keys.size - oddKeys.size))
}
