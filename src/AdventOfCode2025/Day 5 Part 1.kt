package AdventOfCode2025


fun main() {
    val (ranges, ids) = day5
    println(ids.count { id -> ranges.any { id in it } })
}
