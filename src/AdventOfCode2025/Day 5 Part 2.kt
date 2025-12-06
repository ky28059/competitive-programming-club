package AdventOfCode2025


fun main() {
    val (ranges, _) = day5
    val sorted = ranges.sortedWith(Comparator.comparing<LongRange, Long> { it.first }.thenComparing { it.last })

    var count = sorted[0].last - sorted[0].first + 1
    var curr = sorted[0]

    for (r in sorted.drop(1)) {
        if (r.first >= curr.first && r.last <= curr.last) continue

        count += if (r.first <= curr.last) {  // If we overlap with the current range
            r.last - r.first - (curr.last - r.first)
        } else {
            r.last - r.first + 1
        }

        curr = r
    }

    println(count)
}
