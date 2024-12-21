package AdventOfCode2024


fun main() {
    val coords = day10
        .flatMapIndexed { i, s -> s.mapIndexed { j, x -> if (x == '0') i to j else null } }
        .filterNotNull()

    println(coords.sumOf { trailheadPeaks(day10, it).size })
}

fun trailheadPeaks(map: List<String>, coord: Pair<Int, Int>): MutableSet<Pair<Int, Int>> {
    val curr = map[coord.first][coord.second].digitToInt()
    if (curr == 9) return mutableSetOf(coord)

    val ret = mutableSetOf<Pair<Int, Int>>()
    if (coord.first < map.size - 1 && map[coord.first + 1][coord.second].digitToInt() == curr + 1)
        ret += trailheadPeaks(map, Pair(coord.first + 1, coord.second))
    if (coord.first > 0 && map[coord.first - 1][coord.second].digitToInt() == curr + 1)
        ret += trailheadPeaks(map, Pair(coord.first - 1, coord.second))
    if (coord.second < map[0].length - 1 && map[coord.first][coord.second + 1].digitToInt() == curr + 1)
        ret += trailheadPeaks(map, Pair(coord.first, coord.second + 1))
    if (coord.second > 0 && map[coord.first][coord.second - 1].digitToInt() == curr + 1)
        ret += trailheadPeaks(map, Pair(coord.first, coord.second - 1))

    return ret
}
