private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Global Round 13
// Problem A
// Post-contest for lockout, Accepted
fun main() {
    val (n, q) = readInts()
    val arr = readInts().toIntArray()
    val values = IntArray(2)

    for (i in arr) values[i]++

    for (i in 0 until q) {
        val (t, k) = readInts()
        when (t) {
            1 -> {
                values[arr[k - 1]]--
                arr[k - 1] = 1 - arr[k - 1]
                values[arr[k - 1]]++
            }
            2 -> println(if (k > values[1]) 0 else 1)
        }
    }
}
