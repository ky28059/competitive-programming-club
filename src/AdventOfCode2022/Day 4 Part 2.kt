package AdventOfCode2022


fun main() {
    println(day4.count { (left, right) -> left.any { it in right } })
}
