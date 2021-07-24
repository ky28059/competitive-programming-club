import kotlin.math.max

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readLongs() = readStrings().map { it.toLong() } // list of longs

// Codeforces Round 506
// Problem B
// Accepted
fun main() {
    val n = readInt()
    val arr = readLongs()

    var max = 1
    var temp = 1
    for (i in 1 until arr.size) {
        if (arr[i] <= arr[i - 1] * 2) {
            temp++
        } else {
            max = max(max, temp)
            temp = 1
        }
    }

    max = max(max, temp)
    println(max)
}
