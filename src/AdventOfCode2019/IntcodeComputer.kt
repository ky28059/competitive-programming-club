package AdventOfCode2019

import java.util.concurrent.ArrayBlockingQueue
import kotlin.math.pow


// Runs the given intcode program, returning its final memory after all instructions have completed.
// If input and output opcodes are used, a callback must be supplied to retrieve input and broadcast output.
fun runIntcodeProgram(
    program: List<Int>,
    input: (() -> Int)? = null,
    output: ((Int) -> Unit)? = null
): List<Int> {
    val memory = program.toMutableList()
    var pointer = 0

    // Get the one-indexed argument value associated with the instruction, accounting for parameter modes.
    fun getArg(pos: Int): Int {
        // Get the digit in the corresponding place of the instruction with mod and floor division
        return when (memory[pointer] % (10.0.pow(pos + 2).toInt()) / (10.0.pow(pos + 1).toInt())) {
            0 -> memory[memory[pointer + pos]] // Positional mode
            else -> memory[pointer + pos] // Immediate mode
        }
    }

    while (true) {
        val instr = memory[pointer]

        when (instr % 100) {
            // Addition
            1 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = memory[pointer + 3]

                memory[writePos] = arg1 + arg2
                pointer += 4
            }

            // Multiplication
            2 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = memory[pointer + 3]

                memory[writePos] = arg1 * arg2
                pointer += 4
            }

            // Input
            3 -> {
                val writePos = memory[pointer + 1]
                memory[writePos] = input!!()
                pointer += 2
            }

            // Output
            4 -> {
                val arg1 = getArg(1)
                output!!(arg1)
                pointer += 2
            }

            // Jump-if-true
            5 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)

                if (arg1 != 0) pointer = arg2
                else pointer += 3
            }

            // Jump-if-false
            6 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)

                if (arg1 == 0) pointer = arg2
                else pointer += 3
            }

            // Less than
            7 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = memory[pointer + 3]

                memory[writePos] = if (arg1 < arg2) 1 else 0
                pointer += 4
            }

            // Equals
            8 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = memory[pointer + 3]

                memory[writePos] = if (arg1 == arg2) 1 else 0
                pointer += 4
            }

            // Halt
            99 -> break
        }
    }

    return memory.toList()
}

// An intcode computer that runs in a thread and inputs and outputs using blocking queues.
class ThreadedIntcodeComputer(
    private val program: List<Int>,
    private val input: ArrayBlockingQueue<Int>,
    private val output: ArrayBlockingQueue<Int>
) : Thread() {
    override fun run() {
        runIntcodeProgram(
            program,
            input = { input.take() },
            output = { output.put(it) }
        )
    }
}
