private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 713
// Problem D
// Wrong answer on test 2
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val arr = readInts().toMutableList()
        arr.sort()

        val extra = (arr.sum() - arr.last()) - arr.last()
        if (arr.any {it == extra }) {
            arr.removeLast()
            arr.remove(extra)
            println(arr.joinToString(" "))
        } else {
            arr.removeLast()
            if (arr.sum() - arr.last() == arr.last()) {
                arr.removeLast()
                println(arr.joinToString(" "))
            }
            else println(-1)
        }
    }
}