import kotlin.math.floor

private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 714
// Question A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val (n, k) = readInts()
        if (k > floor((n - 1) / 2.0)) println(-1)
        else {
            val arr = (1..n).toMutableList()

            for (j in 1..k) {
                val index = when (j * 2) {
                    arr.size - 1 -> j * 2 + 1
                    arr.size -> j * 2 - 1
                    else -> j * 2 + 2
                }

                val temp = arr[j * 2 - 1]
                arr[j * 2 - 1] = arr[index - 1]
                arr[index - 1] = temp
            }

            println(arr.joinToString(" "))
        }
    }
}