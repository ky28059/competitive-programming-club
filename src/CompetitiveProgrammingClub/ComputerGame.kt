private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs

fun main() {
    val q = readInt()

    // Loop through q queries
    var i = q
    while (i > 0) {
        // k = initial charge
        // n = turns of the game
        // a = amount of charge lost when playing w/out charging
        // b = amount of charge lost when playing w/ charging
        val (k, n, a, b) = readLongs()

        val diff = a - b
        val minPower = b * n

        if (minPower >= k) {
            println(-1)
        } else {
            // Save at least one charge on the computer
            val remaining = k - minPower - 1
            val max = remaining / diff
            // Inelegant
            if (max > n) println(n) else println(max)
        }

        i--
    }
}
