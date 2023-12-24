import java.util.*

private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Global Round 14
// Question C
// Post Contest, Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, m, x) = readInts()
        val blocks = readInts()

        val outputArr = mutableListOf<Int>()
        val heights = IntArray(m + 1)
        val towers = PriorityQueue<Int>(compareBy { heights[it] })

        towers.addAll(1..m)

        for (block in blocks) {
            val minIndex = towers.poll()
            outputArr.add(minIndex)
            heights[minIndex] += block
            towers.add(minIndex)
        }

        println("YES\n${outputArr.joinToString(" ")}")
    }
}
