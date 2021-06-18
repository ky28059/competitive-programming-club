import java.lang.Integer.min

private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Good Bye 2016
// Problem A
// Post contest for lockout, accepted
fun main() {
    val (n, k) = readInts()
    var rem = 240 - k
    var sum = 0
    var i = 1
    while (rem >= 0) {
        rem -= 5 * i++
        sum++
    }
    println(min(sum - 1, n))
}
