package AdventOfCode2022


fun main() {
    val sorted = day1.map { it.sum() }.sortedDescending()
    println(sorted[0] + sorted[1] + sorted[2])
}
