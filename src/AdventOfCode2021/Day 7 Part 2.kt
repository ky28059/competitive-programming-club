package AdventOfCode2021

import kotlin.math.abs


fun main() {
    val min = day7.minOrNull()!!
    val max = day7.maxOrNull()!!
    val diffs = sortedSetOf<Int>()

    for (i in min..max)
        // Arithmetic sequence sum (1 + (j - i))((j - i) / 2)
        diffs.add(day7.fold(0) { sum, j -> sum + (1 + abs(j - i)) * abs(j - i) / 2 })

    println(diffs.first())
}
