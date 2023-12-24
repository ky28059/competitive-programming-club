private fun readInt() = readln().toInt() // single int

// Codeforces Round 728
// Problem A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()

        var str = ""
        for (j in 1 until n step 2) {
            str += if (n % 2 == 1 && j == n - 2) "$n $j ${j + 1} "
            else "${j + 1} $j "
        }
        println(str)
    }
}
