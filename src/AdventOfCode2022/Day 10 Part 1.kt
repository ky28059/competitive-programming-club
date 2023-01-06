package AdventOfCode2022


fun main() {
    var cycles = 1
    var signalStrength = 0
    var register = 1

    fun advanceCycle() {
        cycles++
        if (cycles % 40 == 20) signalStrength += cycles * register
    }

    for (instr in day10) {
        when (instr) {
            "noop" -> advanceCycle()
            else -> {
                val (_, num) = instr.split(" ")
                advanceCycle()
                advanceCycle()
                register += num.toInt()
            }
        }
    }

    println(signalStrength)
}
