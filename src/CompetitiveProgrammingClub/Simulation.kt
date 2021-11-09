private fun readLn() = readLine()!! // string line
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun main() {
    val (n, m) = readInts()
    var str = readLn()

    for (i in 0 until m) {
        val (ls, rs, c1, c2) = readStrings()
        val l = ls.toInt() - 1
        val r = rs.toInt() - 1

        for (k in l..r)
            if (str[k] == c1[0]) str = str.replaceRange(k, k + 1, c2)
    }

    println(str)
}
