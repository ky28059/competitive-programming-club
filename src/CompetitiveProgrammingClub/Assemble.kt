private fun readLn() = readLine()!! // string line

fun main() {
    val str = readLn()
    val chars = mutableMapOf<Char, Int>()

    for (i in str) {
        if (chars[i] == null) chars[i] = 0
        chars[i]?.plus(1)
    }

    println(chars.maxByOrNull { it.value }?.key ?: "")
    println(str)
}
