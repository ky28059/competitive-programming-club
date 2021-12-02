package AdventOfCode2021

fun main() {
    var increases = 0
    for (i in 0 until day1.size - 3) {
        if (day1[i + 3] > day1[i]) increases++
    }

    println(increases)
}
