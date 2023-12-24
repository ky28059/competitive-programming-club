private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Question C
// MLE on test 11
fun main() {
    val (s, n) = readInts()
    val players = IntArray(s + 1)

    for (i in readInts()) players[i]++
    for (i in 1..s) players[i] += players[i - 1]

    val q = readInt()
    for (i in 0 until q) {
        val query = readInt()
        var index = players.binarySearch(query, 1)

        if (index > 0) {
            while (index < players.size - 1 && players[index] == players[index + 1]) index++
            println(index)
        } else {
            println(-index - 2)
        }
    }
}
