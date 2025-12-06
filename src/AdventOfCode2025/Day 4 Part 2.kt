package AdventOfCode2025


fun main() {
    val neighbors = day4.indices.map { i ->
        day4[0].indices.map { j -> neighborRolls(i, j) }
    }

    for (i in neighbors.indices) {
        for (j in neighbors[0].indices) {
            floodFillRolls(neighbors, i, j)
        }
    }

    println(day4.indices.sumOf { i ->
        day4[0].indices.count { j -> day4[i][j] == '@' && neighbors[i][j].size < 4 }
    })
}

fun floodFillRolls(neighbors: List<List<MutableSet<Pair<Int, Int>>>>, i: Int, j: Int) {
    if (neighbors[i][j].size >= 4) return

    for ((i2, j2) in neighbors[i][j].toList()) {  // Clone to avoid `ConcurrentModificationException`
        if (neighbors[i2][j2].remove(i to j)) {
            floodFillRolls(neighbors, i2, j2)
        }
    }
}
