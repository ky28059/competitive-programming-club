package AdventOfCode2025


fun main() {
    val cells = day6.map { it.trim().split(Regex("\\s+")) }
    val ops = cells.last()
    val vals = cells.dropLast(1).map { it.map { s -> s.toLong() } }

    println(vals[0].indices.sumOf { j ->
        if (ops[j] == "*")
            vals.indices.fold(1L) { sum, i -> sum * vals[i][j] }
        else
            vals.indices.fold(0L) { sum, i -> sum + vals[i][j] }
    })
}
