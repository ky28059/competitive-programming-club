private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Post-contest for lockout, Accepted
fun main() {
    val n = readInt()
    val values = readInts()
    println(if (values.any { it == 1 }) "HARD" else "EASY")
}
