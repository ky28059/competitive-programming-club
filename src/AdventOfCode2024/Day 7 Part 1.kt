package AdventOfCode2024


fun main() {
    println(day7.sumOf { (target, row) -> if (checkRow(row.drop(1), target, row[0])) target else 0 })
}

fun checkRow(row: List<Long>, target: Long, sum: Long): Boolean {
    if (row.isEmpty() && sum == target) return true
    if (sum > target) return false
    if (row.isEmpty()) return false

    return checkRow(row.drop(1), target, sum + row[0])
        || checkRow(row.drop(1), target, sum * row[0])
}
