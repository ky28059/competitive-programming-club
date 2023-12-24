import kotlin.math.max

private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 728
// Problem B
// WA test 2
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val arr = readInts()

        var sum = 0
        for (j in arr.indices) {
            val step = if (arr[j] % 2 == 0) 2 else 1

            for (k in max(j + 1, arr[j] - (j + 2)) until arr.size step step) {
                if (j + k + 2 == arr[j] * arr[k]) sum++
            }
        }
        println(sum)
    }
}