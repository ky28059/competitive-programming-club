package AdventOfCode2020

import kotlin.math.absoluteValue


fun main() {
    var north = 0 // Amount relative north
    var east = 0 // Amount relative east
    var facing = 90 // Degrees rotated clockwise, starts facing east

    for (instr in day12) {
        val value = instr.drop(1).toInt()

        when (instr[0]) {
            'N' -> north += value
            'S' -> north -= value
            'E' -> east += value
            'W' -> east -= value
            'R' -> facing += value
            'L' -> facing -= value
            'F' -> {
                var deg = facing % 360
                if (deg < 0) deg += 360 // If the mod is negative, get the correct positive degree by adding 360 to it

                when (deg) {
                    0 -> north += value
                    90 -> east += value
                    180 -> north -= value
                    270 -> east -= value
                }
            }
        }
    }

    println(north.absoluteValue + east.absoluteValue)
}