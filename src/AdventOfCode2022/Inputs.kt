package AdventOfCode2022

import java.io.File

const val BASE_PATH = "src/AdventOfCode2022"

val day1 = File("$BASE_PATH/day1.in").readText().split(Regex("\r?\n\r?\n")).map { it.split(Regex("\r?\n")).map { i -> i.toInt() } }
val day2 = File("$BASE_PATH/day2.in").readLines().map { it.split(" ") }
val day3 = File("$BASE_PATH/day3.in").readLines()
val day4 = File("$BASE_PATH/day4.in").readLines().map { it.split(",").map { s -> s.split("-").map { i -> i.toInt() } }.map { (l, r) -> l..r } }
