package AdventOfCode2024


data class MazeSearchData(val coord: Pair<Int, Int>, val dir: Pair<Int, Int>, val score: Int)

fun main() {
    val dir = (1 to 0) // (x, y), facing E
    val coord = 1 to (day16.size - 2)

    // Path-caching approach: store the min score to reach each point in the maze
    val scores = Array(day16.size) { IntArray(day16[0].length) }
    val targets = ArrayDeque<MazeSearchData>()

    targets.add(MazeSearchData(coord, dir, 0))
    calcMinMazeScore(scores, targets)

    println(scores[1][day16[0].length - 1])
}

tailrec fun calcMinMazeScore(scores: Array<IntArray>, targets: ArrayDeque<MazeSearchData>) {
    val t = targets.removeFirstOrNull() ?: return
    if (day16[t.coord.second][t.coord.first] == '#') return calcMinMazeScore(scores, targets)

    // Already found a better way to reach this square, stop searching
    if (scores[t.coord.second][t.coord.first] != 0 && scores[t.coord.second][t.coord.first] <= t.score)
        return calcMinMazeScore(scores, targets)

    scores[t.coord.second][t.coord.first] = t.score

    val left = t.dir.rotateDeg(-90.0)
    val right = t.dir.rotateDeg(90.0)

    targets.add(MazeSearchData(Pair(t.coord.first + t.dir.first, t.coord.second + t.dir.second), t.dir, t.score + 1))
    targets.add(MazeSearchData(Pair(t.coord.first + left.first, t.coord.second + left.second), left, t.score + 1001))
    targets.add(MazeSearchData(Pair(t.coord.first + right.first, t.coord.second + right.second), right, t.score + 1001))

    calcMinMazeScore(scores, targets)
}
