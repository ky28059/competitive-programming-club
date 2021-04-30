package AdventOfCode2020


fun main() {
    println(getInvalid())
}

fun getInvalid(): Long {
    var prev25 = mutableListOf<Long>()

    // Get the preamble
    for (i in 0..24) {
        prev25.add(day9[i].toLong())
    }

    // Run through remaining inputs
    for (i in 25 until day9.size) {
        var isValid = false
        val input = day9[i].toLong()

        // Check sums
        for (k in 0..24) {
            for (j in (k + 1)..24) {
                if (prev25[k] + prev25[j] == input) isValid = true
            }
        }
        prev25.add(input)
        prev25 = prev25.drop(1).toMutableList()

        if (!isValid) return input
    }
    // Hopefully this never triggers!
    return 0
}