package AdventOfCode2019

import java.io.File

const val BASE_PATH = "src/AdventOfCode2019"


val day2 = File("$BASE_PATH/day2.in").readText().split(",").map { it.toInt() }
