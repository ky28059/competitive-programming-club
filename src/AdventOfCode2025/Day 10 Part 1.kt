package AdventOfCode2025


fun main() {
    println(day10.sumOf { (pattern, buttons, _) ->
        buttons.powerset().filter { pattern == it.reduce { a, b -> a xor b } }.minOf { it.size }
    })
}

fun <T> List<T>.powerset(): List<List<T>> {
    return (1 until 1.shl(this.size)).map { this.filterIndexed { i, _ -> it and (1 shl i) != 0 } }
}

fun parseDay10InputLine(str: String): Triple<Int, List<Int>, List<Int>> {
    val (_, a, b, c) = Regex("\\[([.#]+)] (.+?) \\{(.+)}").matchEntire(str)!!.groupValues

    return Triple(
        a.withIndex().fold(0) { acc, (i, c) -> if (c == '#') acc + 1.shl(i) else acc },
        b.split(" ").map { it.drop(1).dropLast(1).split(",").fold(0) { acc, x -> acc + 1.shl(x.toInt()) } },
        c.split(",").map { it.toInt() }
    )
}
