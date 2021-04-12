private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val n = readLn()
    val contests = readInts().toMutableList()
    contests.sort()
    var k = 1
    for (i in contests) {
        if (i >= k) k++
    }
    println(k - 1)
}
