package AdventOfCode2019

import java.util.concurrent.ArrayBlockingQueue
import kotlin.math.pow


// Runs the given intcode program, returning its final memory after all instructions have completed.
// If input and output opcodes are used, a callback must be supplied to retrieve input and broadcast output.
fun runIntcodeProgram(
    program: List<Long>,
    input: (() -> Long)? = null,
    output: ((Long) -> Unit)? = null
): Map<Int, Long> {
    val memory = mutableMapOf(*program.mapIndexed { i, a -> i to a }.toTypedArray())
    var pointer = 0
    var relativeBase = 0

    while (true) {
        val instr = memory[pointer]?.toInt() ?: 0

        // Get the one-indexed write position associated with the instruction, accounting for parameter modes.
        // Assumes that the parameter mode is either positional or relative.
        fun getReferencedPos(pos: Int): Int {
            // Get the digit in the corresponding place of the instruction with mod and floor division
            return when (instr % (10.0.pow(pos + 2).toInt()) / (10.0.pow(pos + 1).toInt())) {
                0 -> memory[pointer + pos]?.toInt() ?: 0 // Positional mode
                else -> (memory[pointer + pos]?.toInt() ?: 0) + relativeBase // Relative mode
            }
        }

        // Get the one-indexed argument value associated with the instruction, accounting for parameter modes.
        fun getArg(pos: Int): Long {
            // Get the digit in the corresponding place of the instruction with mod and floor division
            return when (instr % (10.0.pow(pos + 2).toInt()) / (10.0.pow(pos + 1).toInt())) {
                1 -> memory[pointer + pos] // Immediate mode
                else -> memory[getReferencedPos(pos)] // Positional or relative mode
            } ?: 0
        }

        when (instr % 100) {
            // Addition
            1 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = getReferencedPos(3)

                memory[writePos] = arg1 + arg2
                pointer += 4
            }

            // Multiplication
            2 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = getReferencedPos(3)

                memory[writePos] = arg1 * arg2
                pointer += 4
            }

            // Input
            3 -> {
                val writePos = getReferencedPos(1)
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

                if (arg1 != 0L) pointer = arg2.toInt()
                else pointer += 3
            }

            // Jump-if-false
            6 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)

                if (arg1 == 0L) pointer = arg2.toInt()
                else pointer += 3
            }

            // Less than
            7 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = getReferencedPos(3)

                memory[writePos] = if (arg1 < arg2) 1 else 0
                pointer += 4
            }

            // Equals
            8 -> {
                val arg1 = getArg(1)
                val arg2 = getArg(2)
                val writePos = getReferencedPos(3)

                memory[writePos] = if (arg1 == arg2) 1 else 0
                pointer += 4
            }

            // Adjust relative base
            9 -> {
                val arg1 = getArg(1)
                relativeBase += arg1.toInt()
                pointer += 2
            }

            // Halt
            99 -> break
        }
    }

    return memory
}

// An intcode computer that runs in a thread and inputs and outputs using blocking queues.
class ThreadedIntcodeComputer(
    private val program: List<Long>,
    private val input: ArrayBlockingQueue<Long>,
    private val output: ArrayBlockingQueue<Long>
) : Thread() {
    override fun run() {
        runIntcodeProgram(
            program,
            input = { input.take() },
            output = { output.put(it) }
        )
    }
}
