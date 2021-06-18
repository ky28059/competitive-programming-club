private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces Round 726
// Problem C
// TLE pretest 2
fun main() {
    val t = readInt()

    outer@ for (i in 0 until t) {
        val n = readInt()
        val heights = readInts().sorted().toMutableList()

        val h = mutableMapOf<Int, Int>()
        for (j in heights.indices) {
            if (h[heights[j]] != null) h[heights[j]] = h[heights[j]]!!.plus(1) else h[heights[j]] = 1
            if (h[heights[j]] == 2) {
                val ind = j - 1

                val arr = heights.subList(ind + 2, heights.size)
                arr.addAll(heights.subList(0, ind))
                reorderList(arr)

                println("$j ${arr.joinToString(" ")} $j")
                continue@outer
            }
        }

        reorderList(heights)
        println(heights.joinToString(" "))
    }
}

fun reorderList(heights: MutableList<Int>) {
    var lastNum = heights[0]
    var index = 1
    while (index < heights.size) {
        if (heights[index] == lastNum) {
            lastNum = heights[index]
            heights.add(heights.removeAt(index))
        } else {
            lastNum = heights[index]
            index++
        }
    }
}