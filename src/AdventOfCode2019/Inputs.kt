package AdventOfCode2019

import java.io.File

const val BASE_PATH = "src/AdventOfCode2019"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.toInt() }
val day2 = File("$BASE_PATH/day2.in").readText().split(",").map { it.toInt() }


val day5 = File("$BASE_PATH/day5.in").readText().split(",").map { it.toInt() }
