private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 658
// Problem A
// Post contest for lockout, accepted
fun main() {
    val t = readInt()

    outer@ for (i in 0 until t) {
        val (_, _) = readInts()
        val n = readInts().toSortedSet()
        val m = readInts().toSortedSet()

        while (n.size != 0 && m.size != 0) {
            val x = n.first()
            val y = m.first()
            if (x == y) {
                println("YES")
                println("1 $x")
                continue@outer
            } else {
                if (x > y) m.remove(y) else n.remove(x)
            }
        }
        println("NO")
    }
}