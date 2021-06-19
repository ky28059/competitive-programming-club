private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 552
// Problem A
// Post contest for lockout, accepted
fun main() {
    val arr = readInts().sorted()
    val sum = arr[3]
    println("${sum - arr[0]} ${sum - arr[1]} ${sum - arr[2]}")
}
