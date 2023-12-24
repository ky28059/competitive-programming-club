private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readLongs() = readStrings().map { it.toLong() } // list of longs

// Educational Codeforces Round 66
// Problem A
// Post contest, accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, k) = readLongs()
        toZero(n, k, 0)
    }
}

tailrec fun toZero(n: Long, k: Long, sum: Long) {
    if (n <= 1) return println(sum + n)

    val mod = n % k
    toZero((n - mod) / k, k, sum + mod + if ((n - mod) / k > 0) 1 else 0)
}
