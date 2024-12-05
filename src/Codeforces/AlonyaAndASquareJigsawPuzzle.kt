private fun readInt() = readln().toInt()
private fun readStrings() = readln().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

// Codeforces Round 990 (Div. 2)
// Problem A
// Post contest, accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val a = readInts()

        var size = 1
        var pieces = 1
        var happy = 1

        for (j in 1 until n) {
            pieces += a[j]
            while (pieces > size * size) size += 2
            if (pieces == size * size) happy++
        }

        println(happy)
    }
}
