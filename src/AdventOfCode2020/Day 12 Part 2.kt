package AdventOfCode2020

import kotlin.math.absoluteValue


fun main() {
    var shipNorth = 0
    var shipEast = 0
    var waypointNorth = 1
    var waypointEast = 10

    fun rotateWaypoint(deg: Int) {
        // Make copies of old values
        val prevEast = waypointEast
        val prevNorth = waypointNorth

        when (deg % 360) {
            90 -> {
                waypointEast = prevNorth
                waypointNorth = -prevEast
            }
            180 -> {
                waypointEast = -prevEast
                waypointNorth = -prevNorth
            }
            270 -> {
                waypointEast = -prevNorth
                waypointNorth = prevEast
            }
        }
    }

    for (instr in day12) {
        val value = instr.drop(1).toInt()

        when (instr[0]) {
            'N' -> waypointNorth += value
            'S' -> waypointNorth -= value
            'E' -> waypointEast += value
            'W' -> waypointEast -= value
            'R' -> rotateWaypoint(value)
            'L' -> rotateWaypoint(360 - value)
            'F' -> {
                shipNorth += waypointNorth * value
                shipEast += waypointEast * value
            }
        }
    }

    println(shipNorth.absoluteValue + shipEast.absoluteValue)
}