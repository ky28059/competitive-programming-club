package AdventOfCode2025


fun main() {
    var angle = 50
    var count = 0

    for (instr in day1) {
        val dir = instr.first()
        val deg = instr.drop(1).toInt()

        when (dir) {
            'L' -> angle -= deg
            'R' -> angle += deg
        }
        angle = angle % 100
        if (angle == 0) count++
    }

    println(count)
}
