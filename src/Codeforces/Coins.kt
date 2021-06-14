private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val (n, s) = readInts()
    println(if (n >= s) 1 else (s - (s % n)) / n + if (s % n > 0) 1 else 0)
}
