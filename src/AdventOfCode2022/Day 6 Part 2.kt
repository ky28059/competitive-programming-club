package AdventOfCode2022


fun main() {
    for (i in 13 until day6.length) {
        if (checkForMarker(i, 14)) {
            println(i + 1)
            break
        }
    }
}
