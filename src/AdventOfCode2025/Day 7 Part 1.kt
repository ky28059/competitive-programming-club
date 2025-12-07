package AdventOfCode2025


fun main() {
    val indices = mutableSetOf(day7[0].indices.first { i -> day7[0][i] == 'S' })
    var count = 0

    for (row in day7.drop(1)) {
        for (i in row.indices) {
            if (row[i] != '^') continue

            // Split beam at this index
            if (indices.remove(i)) {
                indices.add(i - 1)
                indices.add(i + 1)
                count++
            }
        }
    }

    println(count)
}
