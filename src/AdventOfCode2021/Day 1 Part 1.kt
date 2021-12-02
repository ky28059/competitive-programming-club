package AdventOfCode2021

fun main() {
    var prev = 0
    var increases = 0
    for (reading in day1) {
        if (reading > prev) increases++
        prev = reading
    }

    println(increases - 1) // Remove first "increase"
}
