package AdventOfCode2025

import kotlin.math.absoluteValue


fun main() {
    println(day9.maxOf { (x, y) -> day9.maxOf { (x2, y2) -> sideLength(x, x2) * sideLength(y, y2) } })
}

fun sideLength(x: Int, x2: Int): Long {
    return ((x - x2).absoluteValue + 1).toLong()
}
