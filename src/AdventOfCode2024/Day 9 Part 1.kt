package AdventOfCode2024


fun main() {
    val ids = IntArray(day9.sum())

    // Populate ids array from labelled / free blocks; naive implementation
    var free = false
    var i = 0
    var id = 0
    for (block in day9) {
        for (j in 0 until block) {
            ids[i + j] = if (free) -1 else id
        }
        if (!free) id++
        free = !free
        i += block
    }

    // Fill in the free blocks from front to back
    i = 0
    var j = ids.size - 1

    while (i < j) {
        while (ids[i] != -1) i++
        while (ids[j] == -1) j--

        ids[i] = ids[j]
        ids[j] = -1
    }
    ids[j] = ids[i]
    ids[i--] = -1

    println((0..i).sumOf { it * ids[it].toLong() })
}
