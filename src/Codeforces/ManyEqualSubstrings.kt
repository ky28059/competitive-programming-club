private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 506
// Problem A
// Accepted
fun main() {
    val (n, k) = readInts()
    val str = readln()

    var index = 0
    for (i in 1 until str.length) {
        val back = str.substring(str.length - i)
        val front = str.substring(0, i)
        if (front == back) index = i
    }

    val repeatStr = str.drop(index)
    println(str + repeatStr.repeat(k - 1))
}
