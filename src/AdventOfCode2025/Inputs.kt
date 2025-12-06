package AdventOfCode2025

import java.io.File

const val BASE_PATH = "src/AdventOfCode2025"

val day1 = File("$BASE_PATH/day1.in").readLines()

val day3 = File("$BASE_PATH/day3.in").readLines()
val day4 = File("$BASE_PATH/day4.in").readLines()
val day5 = File("$BASE_PATH/day5.in").readText().split("\n\n").let { (r, u) -> r.split("\n").map { it.split("-").let { (l, h) -> l.toLong()..h.toLong() } } to u.split("\n").map { it.toLong() } }
val day6 = File("$BASE_PATH/day6.in").readLines()
