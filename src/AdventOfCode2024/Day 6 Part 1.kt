package AdventOfCode2024


fun main() {
    var row = day6.indexOfFirst { '^' in it }
    var col = day6[row].indexOfFirst { it == '^' }

    val visited = Array(day6.size) { Array(day6[0].length) { false } }
    var dir = (0 to -1) // (x, y)

    while (true) {
        visited[row][col] = true
        var newRow = row + dir.second
        var newCol = col + dir.first

        if (newRow >= day6.size || newCol >= day6[0].length) break

        while (day6[newRow][newCol] == '#') {
            dir = dir.rotateDeg(90.0)
            newRow = row + dir.second
            newCol = col + dir.first
        }

        row = newRow
        col = newCol
    }

    println(visited.sumOf { it.count { x -> x } })
}
