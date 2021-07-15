private fun readLn() = readLine()!! // string line

// Codeforces Round 447
// Problem A
// Post contest, accepted
fun main() {
    val str = readLn()
    var sum = 0
    val prefixSums = IntArray(str.length)

    for (i in str.indices) {
        if (i != 0) prefixSums[i] = prefixSums[i - 1]
        if (str[i] == 'Q') prefixSums[i]++
    }
    for (i in str.indices) {
        if (str[i] == 'A') {
            val left = prefixSums[i]
            val right = prefixSums[prefixSums.size - 1] - left
            sum += left * right
        }
    }

    println(sum)
}
