package AdventOfCode2024


fun main() {
    println(Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(day3).sumOf { m ->
        val (l, r) = m.groupValues.drop(1).map { it.toInt() }
        l * r
    })
}
