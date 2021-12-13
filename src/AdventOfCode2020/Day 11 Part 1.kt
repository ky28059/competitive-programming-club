package AdventOfCode2020


fun main() {
    println(recurseThroughCGOL(day11.toMutableList()))
}

tailrec fun recurseThroughCGOL(currentSeats: MutableList<String>): Int {
    val temp = currentSeats.toMutableList()

    for ((rowNum, row) in currentSeats.withIndex()) {
        for (colNum in row.indices) {
            when (row[colNum]) {
                '.' -> {} // Do nothing if floor seat

                // Probably better way of replacing chars in a string than replaceRange
                // But I cannot reassign them directly using string[n] = x so whatever
                'L' -> if (checkOccupiedNeighbors(rowNum, colNum, currentSeats) == 0) temp[rowNum] = temp[rowNum].replaceRange(colNum, colNum + 1, "#")
                '#' -> if (checkOccupiedNeighbors(rowNum, colNum, currentSeats) >= 4) temp[rowNum] = temp[rowNum].replaceRange(colNum, colNum + 1, "L")
            }
        }
    }
    // If the next iteration is the same as the previous, print occupied seats
    if (temp == currentSeats) return currentSeats.joinToString().filter { it == '#' }.length

    return recurseThroughCGOL(temp)
}

fun checkOccupiedNeighbors(row: Int, col: Int, source: List<String>): Int {
    var neighbors = 0
    val rowMin = if (row == 0) 0 else -1
    val rowMax = if (row == source.size - 1) 0 else 1
    val colMin = if (col == 0) 0 else -1
    val colMax = if (col == source[row].length - 1) 0 else 1

    for (i in rowMin..rowMax) {
        for (k in colMin..colMax) {
            if (source[row + i][col + k] == '#' && (i != 0 || k != 0)) neighbors++
        }
    }
    return neighbors
}