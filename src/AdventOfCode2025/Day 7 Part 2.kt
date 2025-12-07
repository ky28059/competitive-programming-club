package AdventOfCode2025


fun main() {
    val counts = LongArray(day7[0].length)
    counts[day7[0].indices.first { i -> day7[0][i] == 'S' }] = 1

    for (row in day7.drop(1)) {
        for (i in row.indices) {
            if (row[i] != '^') continue

            // Split beam at this index
            if (counts[i] > 0) {
                counts[i - 1] += counts[i]
                counts[i + 1] += counts[i]
                counts[i] = 0
            }
        }
    }

    println(counts.sum())
}
