package AdventOfCode


fun main () {
    val map = ArrayList<String>()
    var treeCount = 0

    // Populate the map
    for (line in day3) {
        map.add(line)
    }

    // Loop through the slope
    var i = 0
    while (i < day3.size) {
        val line = map[i]

        // Handles overflow
        var column = i * 3
        if (column > line.length) column %= line.length

        if (line[column] == '#') treeCount++
        i++
    }

    println(treeCount)
}