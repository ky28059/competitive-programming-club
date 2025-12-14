package AdventOfCode2025


fun main() {
    println(day10.sumOf { (_, buttons, joltages) ->
        mutableMapOf<List<Int>, Int>().let { dp ->
            buttons.powerset().let { it.minOf { c -> minPressesForCombo(it, c, joltages, dp) } }
        }
    })
}

fun minPressesForCombo(
    p: List<List<List<Int>>>,
    combo: List<List<Int>>,
    joltages: List<Int>,
    dp: MutableMap<List<Int>, Int>
): Int {
    val dec = joltages.decrementIndices(combo.flatMap { it })

    if (dec.all { it == 0 }) return combo.size
    if (dec.any { it % 2 != 0 || it < 0 }) return Int.MAX_VALUE

    val sub = dec.map { j -> j / 2 }
    if (!dp.containsKey(sub))
        dp[sub] = p.minOf { minPressesForCombo(p, it, sub, dp) }

    return if (dp[sub] == Int.MAX_VALUE)
        Int.MAX_VALUE
    else
        combo.size + 2 * dp[sub]!!
}
