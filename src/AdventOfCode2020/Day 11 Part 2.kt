package AdventOfCode2020


fun main() {
    println(recurseThroughCGOL2(day11.toMutableList()))
}

tailrec fun recurseThroughCGOL2(currentSeats: MutableList<String>): Int {
    val temp = currentSeats.toMutableList()

    for (rowNum in currentSeats.indices) {
        val row = currentSeats[rowNum]

        for (column in row.indices) {
            when (row[column]) {
                '.' -> {} // Do nothing if floor seat

                // Probably better way of replacing chars in a string than replaceRange
                // But I cannot reassign them directly using string[n] = x so whatever
                'L' -> if (checkOccupiedNeighbors2(rowNum, column, currentSeats) == 0) temp[rowNum] = temp[rowNum].replaceRange(column, column + 1, "#")
                '#' -> if (checkOccupiedNeighbors2(rowNum, column, currentSeats) >= 5) temp[rowNum] = temp[rowNum].replaceRange(column, column + 1, "L")
            }
        }
    }
    // If the next iteration is the same as the previous, print occupied seats
    if (temp == currentSeats) return currentSeats.joinToString().filter { it == '#' }.length

    return recurseThroughCGOL2(temp)
}

fun checkOccupiedNeighbors2(row: Int, col: Int, source: List<String>): Int {
    var neighbors = 0

    for (rise in -1..1) {
        for (run in -1..1) {
            if (!(rise == 0 && run == 0)) neighbors += rayCast(row, col, rise, run, source)
        }
    }
    return neighbors
}

tailrec fun rayCast(y: Int, x: Int, rise: Int, run: Int, source: List<String>): Int {
    try {
        // If the chair exists
        when (source[y + rise][x + run]) {
            '#' -> return 1
            'L' -> return 0
        }
    } catch (e: Exception) {
        // If it throws out of bounds exception, you know there were no chairs in the line
        return 0
    }
    return rayCast(y + rise, x + run, rise, run, source)
}