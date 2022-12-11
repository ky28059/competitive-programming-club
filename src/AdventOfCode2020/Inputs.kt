package AdventOfCode2020

import java.io.File

const val BASE_PATH = "src/AdventOfCode2020"

val day1 = File("$BASE_PATH/day1.in").readLines().map { it.toInt() }
val day2 = File("$BASE_PATH/day2.in").readLines()
val day3 = File("$BASE_PATH/day3.in").readLines()
val day4 = File("$BASE_PATH/day4.in").readText().split(Regex("\r?\n\r?\n")).map { it.replace(Regex("\r?\n"), " ") }
val day5 = File("$BASE_PATH/day5.in").readLines()
val day6 = File("$BASE_PATH/day6.in").readText().split(Regex("\r?\n\r?\n")).map { it.split(Regex("\r?\n")) }
val day7 = File("$BASE_PATH/day7.in").readLines()
val day8 = File("$BASE_PATH/day8.in").readLines()
val day9 = File("$BASE_PATH/day9.in").readLines()
val day10 = File("$BASE_PATH/day10.in").readLines()
val day11 = File("$BASE_PATH/day11.in").readLines()
val day12 = File("$BASE_PATH/day12.in").readLines()
val day13 = File("$BASE_PATH/day13.in").readLines()

val day15 = "16,12,1,0,15,7,11".split(',').map { it.toInt() } // Short so file io is excessive
val day16 = File("$BASE_PATH/day16.in").readText().split(Regex("\r?\n\r?\n"))





val day22 = File("$BASE_PATH/day22.in").readText().split(Regex("\r?\n\r?\n"))
