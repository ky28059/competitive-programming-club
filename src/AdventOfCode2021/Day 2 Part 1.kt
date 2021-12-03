package AdventOfCode2021


fun main() {
    var depth = 0
    var horiz = 0

    for ((instr, value) in day2) {
        when (instr) {
            "forward" -> horiz += value.toInt()
            "up" -> depth -= value.toInt()
            "down" -> depth += value.toInt()
        }
    }

    println(depth * horiz)
}
