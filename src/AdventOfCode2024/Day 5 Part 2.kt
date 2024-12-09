package AdventOfCode2024


fun main() {
    val (rules, updates) = day5

    val adjList = mutableMapOf<Int, MutableList<Int>>()
    for ((before, after) in rules) {
        if (!adjList.containsKey(before)) adjList[before] = mutableListOf()
        adjList[before]!!.add(after)
    }

    println(updates.sumOf { if (checkUpdate(it, adjList)) 0 else processUpdate(it, adjList) })
}

fun processUpdate(update: List<Int>, adjList: MutableMap<Int, MutableList<Int>>): Int {
    val ret = mutableListOf<Int>()

    // Create in degrees from *only* the pages in the update
    val inDeg = update.associateWith { 0 }.toMutableMap()

    for (n in update) {
        if (adjList[n] != null) {
            for (after in adjList[n]!!) {
                if (!inDeg.containsKey(after)) continue
                inDeg[after] = inDeg[after]!! + 1
            }
        }
    }

    // Topological sort on the rules, ignoring pages not in the current update to avoid cycles
    // Add all initial 0-degree nodes to the list
    for ((n, d) in inDeg) {
        if (d != 0) continue
        ret.add(n)
    }

    for (i in update.indices) {
        assert(i < ret.size)

        if (adjList.containsKey(ret[i])) {
            for (adj in adjList[ret[i]]!!) {
                if (!inDeg.containsKey(adj)) continue
                inDeg[adj] = inDeg[adj]!! - 1

                if (inDeg[adj] == 0) ret.add(adj)
            }
        }
    }

    return ret[ret.size / 2]
}
