package AdventOfCode2019


// Runs the given intcode program, returning its final memory after all instructions have completed.
fun runIntcodeProgram(program: List<Int>): List<Int> {
    val memory = program.toMutableList()
    var pointer = 0

    while (true) {
        when (memory[pointer]) {
            // Addition
            1 -> {
                val pos1 = memory[pointer + 1]
                val pos2 = memory[pointer + 2]
                val writePos = memory[pointer + 3]
                memory[writePos] = memory[pos1] + memory[pos2]
                pointer += 4
            }
            // Multiplication
            2 -> {
                val pos1 = memory[pointer + 1]
                val pos2 = memory[pointer + 2]
                val writePos = memory[pointer + 3]
                memory[writePos] = memory[pos1] * memory[pos2]
                pointer += 4
            }
            // Halt
            99 -> break
        }
    }

    return memory.toList()
}
