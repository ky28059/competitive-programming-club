private fun readInt() = readln().toInt() // single int
private fun readStrings() = readln().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// Codeforces LATOKEN Round 1
// Problem A
// Unfinished
fun main() {
    val t = readInt()

    outer@ for (i in 0 until t) {
        val (n, m) = readInts()
        val grid = mutableListOf<List<String>>()

        for (j in 0 until n) grid.add(readln().split("").dropLast(1).drop(1))
        for (j in 0 until n) {
            val row = grid[j]

            val letter = row.dropWhile { it == "." }
            if (letter.isEmpty()) continue

            var lastLetter = letter[0]
            var lastIndex = row.size - letter.size
            for (k in lastIndex until m) {
                if (row[k] == ".") continue

                // If R and W are an odd distance, print NO
                if (row[k] != lastLetter && (k - lastIndex) % 2 == 0) {
                    println("NO")
                    continue@outer
                }

                lastLetter = row[k]
                lastIndex = k
            }
        }

        for (j in 1 until (n - 1) step 2) {
            for (k in 0 until m) {
                // If R and W are an even distance, print NO
                if ((grid[0][k] != "." && grid[0][k] == grid[j][k])
                    || (grid[1][k] != "." && grid[1][k] == grid[j + 1][k])) {
                    println("NO")
                    continue@outer
                }
            }
        }

        // sad
        var index = 0
        var letter = grid[index].dropWhile { it == "." }
        while (letter.isEmpty()) letter = grid[++index].dropWhile { it == "." }

        var lastLetter = letter[0]
        val lastIndex = grid[0].size - letter.size

        fun reverse(x: String): String {
            return if (x == "R") "W" else "R"
        }
        var one = ""
        for (l in 0 until m) {
            one += if (lastIndex % 2 == 1) reverse(lastLetter) else lastLetter
            lastLetter = reverse(lastLetter)
        }
        val two = if (one.length == 1) reverse(one) else one.drop(1) + one[0]

        println("YES")
        for (z in 0 until n) println(if (z % 2 == index % 2) one else two)
    }
}