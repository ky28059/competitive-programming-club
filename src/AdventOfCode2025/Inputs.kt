package AdventOfCode2025

import java.io.File

const val BASE_PATH = "src/AdventOfCode2025"

val day1 = File("$BASE_PATH/day1.in").readLines()

val day3 = File("$BASE_PATH/day3.in").readLines()
val day4 = File("$BASE_PATH/day4.in").readLines()
val day5 = File("$BASE_PATH/day5.in").readText().split("\n\n").let { (r, u) -> r.split("\n").map { it.split("-").let { (l, h) -> l.toLong()..h.toLong() } } to u.split("\n").map { it.toLong() } }
val day6 = File("$BASE_PATH/day6.in").readLines()
val day7 = File("$BASE_PATH/day7.in").readLines()

val day9 = File("$BASE_PATH/day9.in").readLines().map { it.split(",").let { (x, y) -> x.toInt() to y.toInt() } }
val day10 = File("$BASE_PATH/day10.in").readLines().map { parseDay10InputLine(it) }
