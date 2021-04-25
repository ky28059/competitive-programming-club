private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long

// Codeforces Round 718
// Question A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readLong()

        if (n % 2050 != 0L) {
            println(-1)
        } else {
            var ones = n / 2050
            var greater: Long = 0

            // Meh code
            while (ones >= 10) {
                val rem = ones % 10
                greater += rem
                ones = (ones - rem) / 10
            }

            println(ones + greater)
        }
    }
}
