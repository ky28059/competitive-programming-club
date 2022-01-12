package AdventOfCode2021


val day8SignalPatterns = day8.map { it[0].split(" ") }
val day8OutputValues = day8.map { it[1].split(" ") }

fun main() {
    println(day8OutputValues.sumBy { it.count { str -> str.length in listOf(2, 3, 4, 7) } })
}
