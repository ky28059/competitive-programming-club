package AdventOfCode2020

import java.util.*


fun main() {
    println(runElfGame(2020))
}

fun runElfGame(turns: Int): Int {
    val spoken = Hashtable<Int, Int>() // Key is the number being spoken, value is the last turn it was spoken

    // Can probably be done without lastSpoken
    var next = 0
    var lastSpoken = spoken[next]

    for (i in 0 until turns) {
        next = try {
            // If starting numbers remain
            day15[i]
        } catch (e: Exception) {
            // If no starting numbers remain
            if (lastSpoken == null) { // If lastSpoken was unique
                0
            } else {
                i - lastSpoken - 1 // Subtract one because distance from last turn
            }
        }
        lastSpoken = spoken[next]
        spoken[next] = i // Set last spoken into the spoken map
    }
    return next
}
