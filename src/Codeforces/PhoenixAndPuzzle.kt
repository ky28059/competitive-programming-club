import kotlin.math.sqrt

private fun readInt() = readln().toInt() // single int

// Codeforces Global Round 14
// Problem B
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        println(if (sqrt(n / 2.0) % 1 == 0.0 || sqrt(n / 4.0) % 1 == 0.0) "YES" else "NO")
    }
}
