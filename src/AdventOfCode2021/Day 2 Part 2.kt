package AdventOfCode2021


fun main() {
    var depth = 0
    var horiz = 0
    var aim = 0

    for ((instr, value) in day2) {
        when (instr) {
            "forward" -> {
                horiz += value.toInt()
                depth += aim * value.toInt()
            }
            "up" -> aim -= value.toInt()
            "down" -> aim += value.toInt()
        }
    }

    println(depth * horiz)
}
