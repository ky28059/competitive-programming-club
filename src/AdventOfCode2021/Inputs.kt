package AdventOfCode2021

import java.io.File

const val BASE_PATH = "src/AdventOfCode2021"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.toInt() }
val day2 = File("$BASE_PATH/day2.in").readLines().map { it.split(" ") }
val day3 = File("$BASE_PATH/day3.in").readLines()
val day4 = File("$BASE_PATH/day4.in").readText().split(Regex("\r?\n\r?\n"))
val day5 = File("$BASE_PATH/day5.in").readLines().map { it.split(" -> ") }
val day6 = File("$BASE_PATH/day6.in").readText().split(",").map { it.toInt() }
val day7 = File("$BASE_PATH/day7.in").readText().split(",").map { it.toInt() }
val day8 = File("$BASE_PATH/day8.in").readLines().map { it.split(" | ") }
val day9 = File("$BASE_PATH/day9.in").readLines().map { it.map { num -> num.digitToInt() } }
