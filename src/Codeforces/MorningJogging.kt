private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 718
// Problem B
// Failed pretest 2
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, m) = readInts()
        val paths = mutableListOf<MutableList<Int>>()

        for (j in 0 until n) {
            paths.add(readInts().toMutableList())
        }

        // bleh
        val runners = mutableListOf<List<Int>>()
        for (j in 0 until m) {
            val ran = mutableListOf<Int>()

            for (k in paths.indices) {
                val list = paths[k]
                val value = if (k == j) list.minOrNull()!!
                else list.maxOrNull()!!

                list.remove(value)
                ran.add(value)
            }

            runners.add(ran.toList())
        }

        for (j in 0 until n) {
            val round = mutableListOf<Int>()
            for (runner in runners) {
                round.add(runner[j])
            }
            println(round.joinToString(" "))
        }
    }
}