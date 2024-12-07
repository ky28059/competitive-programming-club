package AdventOfCode2024

import java.io.File

const val BASE_PATH = "src/AdventOfCode2024"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.split("   ").map { i -> i.toInt() } }
val day2 = File("$BASE_PATH/day2.in").readLines().map { it.split(" ").map { i -> i.toInt() } }
val day3 = File("$BASE_PATH/day3.in").readText()
