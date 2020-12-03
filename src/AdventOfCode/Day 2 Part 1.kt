package AdventOfCode


fun main() {
    var count = 0

    // Loop through the 1000 passwords
    for (pass in day2) {
        val (policy, password) = pass.split(": ")
        val (numAllowed, letter) = policy.split(" ")
        val (min, max) = numAllowed.split("-").map { it.toInt() }

        // Split by queried letter to find out how many times it occurs
        // Subtract one because splitting creates 1 extra item at the end
        val occurrences = password.split(letter).size - 1
        // If letter occurrences is between the amount allowed by policy, increment the valid password count
        if (occurrences in min..max) count++
    }

    println(count)
}