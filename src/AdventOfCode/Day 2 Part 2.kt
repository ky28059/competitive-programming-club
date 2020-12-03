package AdventOfCode


fun main() {
    var count = 0

    for (pass in day2) {
        val (policy, password) = pass.split(": ")
        val (indices, letter) = policy.split(" ")
        val (leftIndex, rightIndex) = indices.split("-").map { it.toInt() }

        val listPass = password.toList()

        // Many ways of proceeding from here but I thought it'd be elegant-ish to toggle this boolean
        // to determine whether there's only one occurrence
        var valid = false
        // Subtract 1 because indices are 1 indexed instead of 0 indexed
        if (listPass[leftIndex - 1] == letter[0]) valid = !valid
        if (listPass[rightIndex - 1] == letter[0]) valid = !valid
        if (valid) count++
    }

    println(count)
}