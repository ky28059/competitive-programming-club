package AdventOfCode2022


fun main() {
    for (i in 3 until day6.length) {
        if (checkForMarker(i, 4)) {
            println(i + 1)
            break
        }
    }
}

// Checks the signal for a marker of a given size at a given index.
fun checkForMarker(index: Int, size: Int): Boolean {
    val substr = day6.substring(index - size + 1, index + 1)

    // Loop through all combinations of characters to check for duplicates
    for (i in 0 until substr.length - 2) {
        for (j in i + 1 until substr.length) {
            if (substr[i] == substr[j]) return false

            for (k in j + 1 until substr.length) {
                if (substr[i] == substr[k] || substr[j] == substr[k]) return false
            }
        }
    }

    return true
}
