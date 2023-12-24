private fun readInt() = readln().toInt() // single int

// Codeforces Round 719
// Question B
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val str = n.toString()
        val previous = (str.length - 1) * 9

        val char = str[0].toString()
        var current = char.toInt() - 1
        if (n >= char.repeat(str.length).toInt()) current++

        println(previous + current)
    }
}