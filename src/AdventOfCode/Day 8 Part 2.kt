package AdventOfCode

import java.lang.Exception


fun main() {
    // Loop through each instruction to brute force the replacement
    for (i in day8.indices) {
        val replaceable = day8.toMutableList() // Create editable mutable list
        var (instr, value) = day8[i].split(' ')

        // Replace nop with jmp or vice versa
        if (instr == "nop") instr = "jmp" else if (instr == "jmp") instr = "nop"
        replaceable[i] = listOf(instr, value).joinToString(" ")

        try {
            println(loopThroughInstructions2(0, mutableListOf(), 0, replaceable))
        } catch (e: Exception) {
            // Catch so the program does not error
        }
    }
}

// Similar to previous loop through instructions, but this one throws an exception when it detects a loop
// instead of not working if it doesn't loop
tailrec fun loopThroughInstructions2(index: Int, executed: MutableList<Int>, accumulator: Int, source: MutableList<String>): Int {
    if (executed.contains(index)) throw Exception("Program still loops!")

    val (instr, value) = source[index].split(' ')
    executed.add(index)
    var newAccumulator = accumulator
    var relNext = 1

    when (instr) {
        "acc" -> newAccumulator += value.toInt()
        "jmp" -> relNext = value.toInt()
    }

    if (index + relNext >= source.size) return accumulator
    return loopThroughInstructions2(index + relNext, executed, newAccumulator, source)
}