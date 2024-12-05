import kotlin.math.abs

private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Global Round 14
// Problem C
// TLE on Pretest 5
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, m, x) = readInts()
        val blocks = readInts()

        val outputArr = mutableListOf<Int>()
        val towers = mutableListOf<Int>()

        for (j in 0 until m) towers.add(0)

        for (block in blocks) {
            val minIndex = towers.indexOf(towers.minOrNull()!!)
            outputArr.add(minIndex + 1)
            towers[minIndex] += block
        }

        val diffs = mutableSetOf(0)
        for (j in 0 until towers.size - 1) {
            diffs.add(abs(towers[j] - towers[j + 1]))
        }
        val max = diffs.maxOrNull()!!

        if (max > x) println("NO")
        else println("YES\n${outputArr.joinToString(" ")}")
    }
}
