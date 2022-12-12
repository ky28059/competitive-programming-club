package AdventOfCode2022


fun main() {
    var badges = 0

    for (group in day3.chunked(3)) {
        for (item in group[0]) {
            if (item in group[1] && item in group[2]) {
                badges += priority(item)
                break
            }
        }
    }

    println(badges)
}
