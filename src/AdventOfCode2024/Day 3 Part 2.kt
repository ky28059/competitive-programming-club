package AdventOfCode2024


fun main() {
    var enable = true
    var sum = 0

    for (m in Regex("(?:do|don't)\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(day3)) {
        when {
            m.groupValues[0].startsWith("do(") -> enable = true
            m.groupValues[0].startsWith("don't(") -> enable = false
            enable -> sum += m.groupValues[1].toInt() * m.groupValues[2].toInt()
        }
    }

    println(sum)
}
