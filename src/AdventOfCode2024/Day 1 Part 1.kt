package AdventOfCode2024

import kotlin.math.absoluteValue


fun main() {
    val left = day1.map { it[0] }.sorted()
    val right = day1.map { it[1] }.sorted()

    println(left.indices.sumOf { (left[it] - right[it]).absoluteValue })
}
