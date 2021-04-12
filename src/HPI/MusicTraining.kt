private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Advance Question C
// Accepted
fun main() {
    val n = readInt()
    val a = mutableListOf<Int>()
    val b = mutableListOf<Int>()

    for (i in 1..n) a.add(readInt())
    for (i in 1..n) b.add(readInt())

    val (s, t) = readInts()
    var sum = 0

    a.sort()
    b.sort()

    for (i in 0 until n) {
        if (b[i] > a[i]) sum += (b[i] - a[i]) * s
        else if (a[i] > b[i]) sum += (a[i] - b[i]) * t
    }

    println(sum)
}
