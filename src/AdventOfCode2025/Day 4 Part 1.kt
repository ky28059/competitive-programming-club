package AdventOfCode2025


fun main() {
    println(day4.indices.sumOf { i ->
        day4[0].indices.count { j -> day4[i][j] == '@' && neighborRolls(i, j).size < 4 }
    })
}

fun neighborRolls(i: Int, j: Int): MutableSet<Pair<Int, Int>> {
    if (day4[i][j] != '@') return mutableSetOf()

    val adj = mutableSetOf<Pair<Int, Int>>()

    if (i > 0 && day4[i - 1][j] == '@')
        adj.add(i - 1 to j)
    if (i < day4.size - 1 && day4[i + 1][j] == '@')
        adj.add(i + 1 to j)
    if (j > 0 && day4[i][j - 1] == '@')
        adj.add(i to j - 1)
    if (j < day4[0].length - 1 && day4[i][j + 1] == '@')
        adj.add(i to j + 1)

    if (i > 0 && j > 0 && day4[i - 1][j - 1] == '@')
        adj.add(i - 1 to j - 1)
    if (i > 0 && j < day4[0].length - 1 && day4[i - 1][j + 1] == '@')
        adj.add(i - 1 to j + 1)
    if (i < day4.size - 1 && j > 0 && day4[i + 1][j - 1] == '@')
        adj.add(i + 1 to j - 1)
    if (i < day4.size - 1 && j < day4[0].length - 1 && day4[i + 1][j + 1] == '@')
        adj.add(i + 1 to j + 1)

    return adj
}
