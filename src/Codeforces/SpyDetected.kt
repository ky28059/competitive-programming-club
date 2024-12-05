private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 713
// Problem A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val arr = readInts()

        if (arr.count { it == arr[0] } > 1) {
            println(arr.indexOf(arr.filter { it != arr[0] }[0]) + 1)
        } else {
            println(1)
        }
    }
}