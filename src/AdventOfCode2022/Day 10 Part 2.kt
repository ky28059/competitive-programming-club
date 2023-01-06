package AdventOfCode2022

import kotlin.math.abs


fun main() {
    var cycles = 1
    var register = 1
    var display = ""

    fun advanceCycle() {
        // Convert 1-indexed cycle number to 0-indexed position, wrap around lines
        display += if (abs(register - ((cycles - 1) % 40)) <= 1) "#" else "."
        if (cycles % 40 == 0) display += "\n"
        cycles++
    }

    for (instr in day10) {
        when (instr) {
            "noop" -> advanceCycle()
            else -> {
                val (_, num) = instr.split(" ")
                advanceCycle()
                advanceCycle()
                register += num.toInt()
            }
        }
    }

    println(display)
}
