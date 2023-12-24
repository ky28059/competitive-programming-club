private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val n = readln()
    val contests = readInts().toMutableList()
    contests.sort()
    var k = 1
    for (i in contests) {
        if (i >= k) k++
    }
    println(k - 1)
}
