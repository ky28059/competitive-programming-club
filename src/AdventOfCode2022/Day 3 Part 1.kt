package AdventOfCode2022


fun main() {
    var misplaced = 0

    // Split each rucksack into two equal compartments
    for ((left, right) in day3.map { it.take(it.length / 2) to it.substring(it.length / 2) }) {
        for (item in left) {
            if (item in right) {
                misplaced += priority(item)
                break
            }
        }
    }

    println(misplaced)
}

// Gets the priority of an item given its character.
// a-z: 1-26
// A-Z: 27-52
fun priority(item: Char): Int {
    return when (item) {
        in 'a'..'z' -> item.toInt() - 96
        else -> item.toInt() - 38
    }
}
