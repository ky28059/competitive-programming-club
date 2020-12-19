package AdventOfCode

import java.util.*


fun main() {
    val spoken = Hashtable<Int, Int>() // Key is the number being spoken, value is the last turn it was spoken

    // Can probably be done without lastSpoken
    var next = 0
    var lastSpoken = spoken[next]

    // Takes like 5 minutes to finish
    for (i in 0..29999999) {
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
        println("$i: Spoke $next, ${if (lastSpoken == null) "unique" else "last spoken $lastSpoken"}")
        spoken[next] = i // Set last spoken into the spoken map
    }
    println(next)
}

