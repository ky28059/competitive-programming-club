import kotlin.math.min

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) runTestCase()
}

fun runTestCase() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(n)

    var curr = 1

    for (i in 0 until m) {
        val pos = i * n
        val next = curr * m

        val lenCurr = min(next - pos, n)
        val lenNext = n - lenCurr

        println("$lenCurr $curr $lenNext ${(curr % n) + 1}")

        if (lenNext > 0) curr++
    }
}
