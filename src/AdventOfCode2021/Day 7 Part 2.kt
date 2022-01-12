package AdventOfCode2021

import kotlin.math.abs


fun main() {
    val min = day7.minOrNull()!!
    val max = day7.maxOrNull()!!
    val diffs = sortedSetOf<Int>()

    for (i in min..max)
        // Arithmetic sequence sum (1 + (j - i))((j - i) / 2)
        diffs.add(day7.sumBy { (1 + abs(it - i)) * abs(it - i) / 2 })

    println(diffs.first())
}
