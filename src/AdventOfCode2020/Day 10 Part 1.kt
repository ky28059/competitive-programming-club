package AdventOfCode2020


fun main() {
    val adapters = day10.map { it.toInt() }.toMutableList()
    adapters.add(0)
    adapters.sort()

    var oneJ = 0
    var twoJ = 0
    var threeJ = 0

    for (i in 1 until adapters.size) {
        // Check diff between previous
        when (adapters[i] - adapters[i - 1]) {
            1 -> oneJ++
            2 -> twoJ++
            3 -> threeJ++
        }
    }

    // Final adapter is 3 above your highest
    threeJ++
    println(oneJ * threeJ)
}