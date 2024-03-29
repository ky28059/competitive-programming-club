package AdventOfCode2019

import java.io.File

const val BASE_PATH = "src/AdventOfCode2019"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.toInt() }
val day2 = File("$BASE_PATH/day2.in").readText().split(",").map { it.toLong() }


val day5 = File("$BASE_PATH/day5.in").readText().split(",").map { it.toLong() }
val day6 = File("$BASE_PATH/day6.in").readLines().map { it.split(")") }
val day7 = File("$BASE_PATH/day7.in").readText().split(",").map { it.toLong() }
val day8 = File("$BASE_PATH/day8.in").readText().map { it.digitToInt() }
val day9 = File("$BASE_PATH/day9.in").readText().split(",").map { it.toLong() }
