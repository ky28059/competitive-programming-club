fun main() {
    val str = readln()
    val chars = mutableMapOf<Char, Int>()

    for (i in str) {
        if (chars[i] == null) chars[i] = 0
        chars[i]?.plus(1)
    }

    println(chars.maxByOrNull { it.value }?.key ?: "")
    println(str)
}
