package AdventOfCode2024


fun main() {
    val (rules, updates) = day5

    val aftMap = mutableMapOf<Int, MutableList<Int>>()
    for ((before, after) in rules) {
        if (!aftMap.containsKey(before)) aftMap[before] = mutableListOf()
        aftMap[before]!!.add(after)
    }

    println(updates.sumOf { if (checkUpdate(it, aftMap)) it[it.size / 2] else 0 })
}

fun checkUpdate(update: List<Int>, aftMap: MutableMap<Int, MutableList<Int>>): Boolean {
    val prev = mutableSetOf<Int>()

    for (n in update) {
        if (aftMap[n] != null && aftMap[n]!!.any { prev.contains(it) })
            return false
        prev.add(n)
    }

    return true
}
