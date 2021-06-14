private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int

fun main() {
    val n = readInt()
    val str = readLn()

    println(if (str.toLowerCase().toList().containsAll(('a'..'z').toList())) "YES" else "NO")
}
