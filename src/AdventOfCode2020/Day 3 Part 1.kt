package AdventOfCode2020


fun main () {
    var treeCount = 0

    // Loop through the slope
    for (i in day3.indices) {
        val line = day3[i]

        // Handles overflow
        var column = i * 3
        if (column > line.length) column %= line.length

        if (line[column] == '#') treeCount++
    }

    println(treeCount)
}