private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Global Round 14
// Question A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, x) = readInts()
        val weights = readInts()

        if (weights.sum() == x) println("NO")
        else {
            println("YES")
            val sorted = weights.sortedDescending().toMutableList()

            val prefixSums = mutableListOf(0)
            for (j in 0 until (sorted.size - 1)) {
                if (prefixSums[j] + sorted[j] > x) break
                if (prefixSums[j] + sorted[j] == x) {
                    val temp = sorted[j]
                    sorted[j] = sorted[j + 1]
                    sorted[j + 1] = temp
                    break
                }
                prefixSums.add(prefixSums[j] + sorted[j])
            }
            println(sorted.joinToString(" "))
        }
    }
}