package AdventOfCode2022

import java.io.File

val day1 = File("src/AdventOfCode2022/day1.in").readText().split(Regex("\r?\n\r?\n")).map { it.split(Regex("\r?\n")).map { i -> i.toInt() } }
