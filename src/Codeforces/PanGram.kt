private fun readInt() = readln().toInt() // single int

fun main() {
    val n = readInt()
    val str = readln()

    println(if (str.lowercase().toList().containsAll(('a'..'z').toList())) "YES" else "NO")
}
