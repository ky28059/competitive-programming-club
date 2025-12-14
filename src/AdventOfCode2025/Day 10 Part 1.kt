package AdventOfCode2025


fun main() {
    println(day10.sumOf { (pattern, buttons, _) ->
        buttons.powerset()
            .filter { pattern == it.fold(0) { a, b -> a xor b.indicesToInt() } }
            .minOf { it.size }
    })
}

fun parseDay10InputLine(str: String): Triple<Int, List<List<Int>>, List<Int>> {
    val (_, a, b, c) = Regex("\\[([.#]+)] (.+?) \\{(.+)}").matchEntire(str)!!.groupValues

    return Triple(
        a.withIndex().fold(0) { acc, (i, c) -> if (c == '#') acc + (1 shl i) else acc },
        b.split(" ").map { it.drop(1).dropLast(1).split(",").map { x -> x.toInt() } },
        c.split(",").map { it.toInt() }
    )
}
