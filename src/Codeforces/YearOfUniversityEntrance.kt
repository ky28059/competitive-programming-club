private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// VK Cup 2017 - Qualification 1
// Problem A
// Post contest for lockout, accepted
fun main() {
    val n = readInt()
    val arr = readInts().sorted()
    println(arr[arr.size / 2])
}
