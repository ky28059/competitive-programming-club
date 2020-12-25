package AdventOfCode2020


fun main() {
    val visited = arrayListOf<Int>()

    for (pass in day5) {
        visited.add(calcSeatID(pass))
    }

    visited.sort()

    // Find your missing seat
    for (i in 1 until visited.size) {
        if (visited[i - 1] + 2 == visited[i]) println(visited[i] - 1)
    }
}