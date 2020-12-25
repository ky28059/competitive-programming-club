package AdventOfCode2020


fun main () {
    var treeCount: Long = 1

    for (i in 1..5) {
        var rise: Int = 1
        var run: Int = 1

        // Assign slopes based on current iteration
        when (i) {
            2 -> run = 3
            3 -> run = 5
            4 -> run = 7
            5 -> rise = 2
        }

        // Loop through the slope
        var k = 0
        var localTreeCount = 0

        while (k < day3.size) {
            val line = day3[k]

            // In order for this multiplication to work, k needs to be the number of times iterated,
            // not just the current row, so it is divided by rise to get that value
            val column = ((k / rise) * run) % line.length // Handles overflow

            if (line[column] == '#') localTreeCount++
            k += rise
        }

        // Multiply sums together
        treeCount *= localTreeCount
    }

    println(treeCount)
}