package AdventOfCode2022


fun main() {
    // Not very efficient, but using `IntRange`s makes part 2 easier
    println(day4.count { (left, right) -> left.all { it in right } || right.all { it in left } })
}
