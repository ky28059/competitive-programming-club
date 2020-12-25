package AdventOfCode2020


fun main() {
    println(recurseThroughCGOL(day11.toMutableList()))
}

tailrec fun recurseThroughCGOL(currentSeats: MutableList<String>): Int {
    val temp = currentSeats.toMutableList()

    for (rowNum in currentSeats.indices) {
        val row = currentSeats[rowNum]

        for (column in row.indices) {
            when (row[column]) {
                '.' -> {} // Do nothing if floor seat

                // Probably better way of replacing chars in a string than replaceRange
                // But I cannot reassign them directly using string[n] = x so whatever
                'L' -> if (checkOccupiedNeighbors(rowNum, column, currentSeats) == 0) temp[rowNum] = temp[rowNum].replaceRange(column, column + 1, "#")
                '#' -> if (checkOccupiedNeighbors(rowNum, column, currentSeats) >= 4) temp[rowNum] = temp[rowNum].replaceRange(column, column + 1, "L")
            }
        }
    }
    // If the next iteration is the same as the previous, print occupied seats
    if (temp == currentSeats) return currentSeats.joinToString().filter { it == '#' }.length

    return recurseThroughCGOL(temp)
}

fun checkOccupiedNeighbors(row: Int, col: Int, source: List<String>): Int {
    var neighbors = 0
    var rowMin = -1; var rowMax = 1
    var colMin = -1; var colMax = 1

    // Check ranges to catch outOfBounds exceptions
    // Inelegant
    if (row == 0) rowMin = 0
    if (col == 0) colMin = 0
    if (row == source.size - 1) rowMax = 0
    if (col == source[row].length - 1) colMax = 0

    for (i in rowMin..rowMax) {
        for (k in colMin..colMax) {
            if (source[row + i][col + k] == '#' && (i != 0 || k != 0)) neighbors++
        }
    }
    return neighbors
}