package AdventOfCode2021

import kotlin.math.abs


fun main() {
    val min = day7.minOrNull()!!
    val max = day7.maxOrNull()!!
    val diffs = sortedSetOf<Int>()

    for (i in min..max)
        diffs.add(day7.fold(0) { sum, j -> sum + abs(j - i) })

    println(diffs.first())
}
