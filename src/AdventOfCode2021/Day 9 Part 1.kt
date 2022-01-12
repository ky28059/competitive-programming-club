package AdventOfCode2021


fun main() {
    var sum = 0

    for (i in day9.indices) {
        for (j in day9[i].indices) {
            if (isLocalMinimum(i, j, day9)) sum += day9[i][j] + 1
        }
    }

    println(sum)
}

fun isLocalMinimum(i: Int, j: Int, grid: List<List<Int>>): Boolean {
    val value = grid[i][j]

    if (i + 1 < grid.size && grid[i + 1][j] <= value) return false
    if (i - 1 >= 0 && grid[i - 1][j] <= value) return false
    if (j + 1 < grid[i].size && grid[i][j + 1] <= value) return false
    return j - 1 < 0 || grid[i][j - 1] > value
}
