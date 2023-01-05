package AdventOfCode2022


val day5Stacks = listOf(
    ArrayDeque(listOf("V", "Q", "W", "M", "B", "N", "Z", "C")),
    ArrayDeque(listOf("B", "C", "W", "R", "Z", "H")),
    ArrayDeque(listOf("J", "R", "Q", "F")),
    ArrayDeque(listOf("T", "M", "N", "F", "H", "W", "S", "Z")),
    ArrayDeque(listOf("P", "Q", "N", "L", "W", "F", "G")),
    ArrayDeque(listOf("W", "P", "L")),
    ArrayDeque(listOf("J", "Q", "C", "G", "R", "D", "B", "V")),
    ArrayDeque(listOf("W", "B", "N", "Q", "Z")),
    ArrayDeque(listOf("J", "T", "G", "C", "F", "L", "H"))
)

fun main() {
    for ((count, stacks) in day5) {
        val (from, to) = stacks
        for (i in 0 until count) {
            val value = day5Stacks[from - 1].removeFirst()
            day5Stacks[to - 1].addFirst(value)
        }
    }

    println(day5Stacks.joinToString("") { it.first() })
}
