package AdventOfCode2024

import kotlin.math.pow


fun main() {
    val cmp = ChronospatialComputer(day17)
    println(cmp.run().joinToString(","))
}

class ChronospatialComputer(inp: String) {
    private var regA: Int
    private var regB: Int
    private var regC: Int

    val prog: List<Int>

    private var ip = 0
    private var output = mutableListOf<Int>()

    init {
        val (_, a, b, c, p) = Regex("Register A: (\\d+)\r?\nRegister B: (\\d+)\r?\nRegister C: (\\d+)\r?\n\r?\nProgram: (.+)").matchEntire(inp)!!.groupValues
        regA = a.toInt()
        regB = b.toInt()
        regC = c.toInt()
        prog = p.split(",").map { it.toInt() }
    }

    private fun parseComboOp(op: Int): Int {
        return when (op) {
            in 0..3 -> op
            4 -> regA
            5 -> regB
            6 -> regC
            else -> throw Exception("Invalid op: $op")
        }
    }

    private fun runOp() {
        val code = prog[ip]
        val operand = prog[ip + 1]

        when (code) {
            0 -> regA = (regA / (2.0).pow(parseComboOp(operand))).toInt() // adv
            1 -> regB = regB xor operand // bxl
            2 -> regB = parseComboOp(operand) % 8 // bst
            3 -> { // jnz
                if (regA != 0) ip = operand - 2 // Account for ip autoincrement
            }
            4 -> regB = regB xor regC // bxc
            5 -> output.add(parseComboOp(operand) % 8) // out
            6 -> regB = (regA / (2.0).pow(parseComboOp(operand))).toInt() // bdv
            7 -> regC = (regA / (2.0).pow(parseComboOp(operand))).toInt() // cdv
            else -> throw Exception("Invalid op: $code")
        }
        ip += 2
    }

    fun run(): MutableList<Int> {
        while (ip < prog.size) runOp()
        return output
    }

    fun reset(regA: Int) {
        this.regA = regA
        regB = 0
        regC = 0
        ip = 0
    }
}
