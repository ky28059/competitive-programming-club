package AdventOfCode2022


fun main() {
    println(findMarker(4))
}

// Returns the last index of a marker of the given size in the signal.
fun findMarker(size: Int): Int {
    for (i in size - 1 until day6.length) {
        if (checkForMarker(i, size)) return i + 1
    }
    return -1
}

// Checks the signal for a marker of a given size at a given index.
fun checkForMarker(index: Int, size: Int): Boolean {
    val substr = day6.substring(index - size + 1, index + 1)

    // Loop through all combinations of characters to check for duplicates
    for (i in 0 until substr.length - 1) {
        for (j in i + 1 until substr.length) {
            if (substr[i] == substr[j]) return false
        }
    }

    return true
}
