package AdventOfCode2021


fun main() {
    var increases = 0
    var prev = day1[0]

    for (i in 1 until day1.size) {
        val reading = day1[i]
        if (reading > prev) increases++
        prev = reading
    }

    println(increases)
}
