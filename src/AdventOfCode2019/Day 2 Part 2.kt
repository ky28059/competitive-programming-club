package AdventOfCode2019


fun main() {
    val instrs = day2.toMutableList()

    for (i in 0..99) {
        for (j in 0..99) {
            instrs[1] = i
            instrs[2] = j

            val res = intcodeComputer(instrs.toList())
            if (res[0] == 19690720) {
                println(100 * i + j)
                break
            }
        }
    }
}
