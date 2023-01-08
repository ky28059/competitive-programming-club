package AdventOfCode2019


fun main() {
    val instrs = day2.toMutableList()
    instrs[1] = 12
    instrs[2] = 2

    val res = runIntcodeProgram(instrs.toList())
    println(res[0])
}
