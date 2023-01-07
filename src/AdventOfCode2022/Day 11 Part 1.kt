package AdventOfCode2022


val monkey0Queue = ArrayDeque(listOf(53, 89, 62, 57, 74, 51, 83, 97))
val monkey1Queue = ArrayDeque(listOf(85, 94, 97, 92, 56))
val monkey2Queue = ArrayDeque(listOf(86, 82, 82))
val monkey3Queue = ArrayDeque(listOf(94, 68))
val monkey4Queue = ArrayDeque(listOf(83, 62, 74, 58, 96, 68, 85))
val monkey5Queue = ArrayDeque(listOf(50, 68, 95, 82))
val monkey6Queue = ArrayDeque(listOf(75))
val monkey7Queue = ArrayDeque(listOf(92, 52, 85, 89, 68, 82))

val day11Monkeys = listOf(
    Monkey(monkey0Queue, 13, monkey1Queue, monkey5Queue) { it * 3 },
    Monkey(monkey1Queue, 19, monkey5Queue, monkey2Queue) { it + 2 },
    Monkey(monkey2Queue, 11, monkey3Queue, monkey4Queue) { it + 1 },
    Monkey(monkey3Queue, 17, monkey7Queue, monkey6Queue) { it + 5 },
    Monkey(monkey4Queue, 3, monkey3Queue, monkey6Queue) { it + 4 },
    Monkey(monkey5Queue, 7, monkey2Queue, monkey4Queue) { it + 8 },
    Monkey(monkey6Queue, 5, monkey7Queue, monkey0Queue) { it * 7 },
    Monkey(monkey7Queue, 2, monkey0Queue, monkey1Queue) { it * it }
)

fun main() {
    val inspected = IntArray(day11Monkeys.size)

    for (i in 0 until 20) {
        for (j in day11Monkeys.indices) {
            inspected[j] += day11Monkeys[j].process()
        }
    }

    val sorted = inspected.sortedDescending()
    println(sorted[0] * sorted[1])
}

// A monkey, as described by https://adventofcode.com/2022/day/11.
class Monkey(
    val items: ArrayDeque<Int>,
    private val test: Int,
    private val ifQueue: ArrayDeque<Int>,
    private val elseQueue: ArrayDeque<Int>,
    private val operation: (Int) -> Int
) {
    fun process(): Int {
        val inspected = items.size

        // Inspect all items, applying the operation and dividing by 3 to get final worry count
        while (!items.isEmpty()) {
            val item = operation(items.removeFirst()) / 3
            if (item % test == 0) ifQueue.addLast(item) else elseQueue.addLast(item)
        }

        return inspected
    }
}
