package AdventOfCode2024


fun main() {
    val left = day1.map { it[0] }
    val rightFreq = day1.map { it[1] }.groupingBy { it }.eachCount()

    println(left.sumOf { it * (rightFreq[it] ?: 0) })
}
