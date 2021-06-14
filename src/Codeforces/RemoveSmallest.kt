private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val t = readInt()

    outer@ for (i in 0 until t) {
        val n = readInt()
        val arr = readInts().toSortedSet().toList()

        for (j in 0 until (arr.size - 1)) {
            if (arr[j] + 1 != arr[j + 1]) {
                println("NO")
                continue@outer
            }
        }
        println("YES")
    }
}
