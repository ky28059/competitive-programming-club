package AdventOfCode2020


fun main() {
    println(loopThroughInstructions(0, mutableListOf(), 0))
}

tailrec fun loopThroughInstructions(index: Int, executed: MutableList<Int>, accumulator: Int): Int {
    if (executed.contains(index)) return accumulator

    val (instr, value) = day8[index].split(' ')
    executed.add(index)
    var newAccumulator = accumulator
    var relNext = 1

    when (instr) {
        "acc" -> newAccumulator += value.toInt()
        "jmp" -> relNext = value.toInt()
    }

    return loopThroughInstructions(index + relNext, executed, newAccumulator)
}