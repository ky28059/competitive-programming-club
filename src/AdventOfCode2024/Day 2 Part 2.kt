package AdventOfCode2024


fun main() {
    println(day2.count { row -> row.indices.any { rowSafe(row.filterIndexed { j, _ -> j != it }) } })
}
