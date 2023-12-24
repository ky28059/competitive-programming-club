private fun readInt() = readln().toInt() // single int

// Codeforces Round 550
// Problem A
// Post contest for lockout, accepted
fun main() {
    val n = readInt()

    outer@ for (i in 0 until n) {
        val str = readln().toCharArray()
        str.sort()
        for (j in 0 until str.size - 1) if (str[j] + 1 != str[j + 1]) {
            println("NO")
            continue@outer
        }
        println("YES")
    }
}
