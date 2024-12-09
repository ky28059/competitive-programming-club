package AdventOfCode2024

import java.io.File

const val BASE_PATH = "src/AdventOfCode2024"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.split("   ").map { i -> i.toInt() } }
val day2 = File("$BASE_PATH/day2.in").readLines().map { it.split(" ").map { i -> i.toInt() } }
val day3 = File("$BASE_PATH/day3.in").readText()

val day5 = File("$BASE_PATH/day5.in").readText().split(Regex("\r?\n\r?\n")).let { (r, u) -> r.split(Regex("\r?\n")).map { it.split("|").map { x -> x.toInt() } } to u.split(Regex("\r?\n")).map { it.split(",").map { x -> x.toInt() } } }
val day6 = File("$BASE_PATH/day6.in").readLines()
val day7 = File("$BASE_PATH/day7.in").readLines().map { it.split(": ").let { (t, n) -> t.toLong() to n.split(" ").map { i -> i.toLong() } } }
