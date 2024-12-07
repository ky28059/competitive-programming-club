package AdventOfCode2024


fun main() {
    println(day2.count { rowSafe(it) })
}

fun rowSafe(l: List<Int>): Boolean {
    return when {
        l[0] == l[1] -> false
        l[0] > l[1] -> l.zipWithNext().all { (i, j) -> i > j && i - j <= 3 }
        else -> l.zipWithNext().all { (i, j) -> i < j && j - i <= 3 }
    }
}
