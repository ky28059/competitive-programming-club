package AdventOfCode2021

import java.io.File

val day1: List<Int> = File("src/AdventOfCode2021/day1.in").readLines().map { it.toInt() }
val day2: List<List<String>> = File("src/AdventOfCode2021/day2.in").readLines().map { it.split(" ") }
val day3: List<String> = File("src/AdventOfCode2021/day3.in").readLines()
val day4: List<String> = File("src/AdventOfCode2021/day4.in").readText().split(Regex("\r?\n\r?\n"))
val day5: List<List<String>> = File("src/AdventOfCode2021/day5.in").readLines().map { it.split(" -> ") }
val day6: List<Int> = File("src/AdventOfCode2021/day6.in").readLines()[0].split(",").map { it.toInt() }
val day7: List<Int> = File("src/AdventOfCode2021/day7.in").readLines()[0].split(",").map { it.toInt() }
val day8: List<List<String>> = File("src/AdventOfCode2021/day8.in").readLines().map { it.split(" | ") }
val day9: List<List<Int>> = File("src/AdventOfCode2021/day9.in").readLines().map { it.map { num -> num.toString().toInt() } }
