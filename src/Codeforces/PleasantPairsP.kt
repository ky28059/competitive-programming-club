private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 728
// Problem B
// Post Contest, Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val arr = readInts()

        var sum = 0
        for (j in arr.indices) {
            for (k in arr[j] - j - 2 until arr.size step arr[j]) {
                if (k > j && j.toLong() + k + 2 == arr[j].toLong() * arr[k]) sum++
            }
        }
        println(sum)
    }
}