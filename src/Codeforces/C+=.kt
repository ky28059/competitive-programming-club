private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs

// Codeforces Global Round 8
// Problem A
// For lockout, accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        var (a, b, n) = readInts()
        var count = 0

        while (a <= n && b <= n) {
            if (a > b) b += a else a += b
            count++
        }

        println(count)
    }
}
