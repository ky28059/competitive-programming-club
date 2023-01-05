package AdventOfCode2022


fun main() {
    for ((count, stacks) in day5) {
        val (from, to) = stacks
        val transferStack = ArrayDeque<String>()

        // Preserve crate order while transferring using intermediary stack to queue pushes
        for (i in 0 until count) transferStack.addFirst(day5Stacks[from - 1].removeFirst())
        for (crate in transferStack) day5Stacks[to - 1].addFirst(crate)
    }

    println(day5Stacks.joinToString("") { it.first() })
}
