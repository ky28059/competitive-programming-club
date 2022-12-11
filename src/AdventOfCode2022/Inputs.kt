package AdventOfCode2022

import java.io.File

const val BASE_PATH = "src/AdventOfCode2022"

val day1 = File("$BASE_PATH/day1.in").readText().split(Regex("\r?\n\r?\n")).map { it.split(Regex("\r?\n")).map { i -> i.toInt() } }
