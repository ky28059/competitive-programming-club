private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (a, b) = readInts()
        println(a + b)
    }
}
