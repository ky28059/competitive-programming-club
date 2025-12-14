package AdventOfCode2025


fun <T> List<T>.powerset(): List<List<T>> {
    return (0 until 1.shl(this.size)).map { this.filterIndexed { i, _ -> it and (1 shl i) != 0 } }
}

fun List<Int>.indicesToInt(): Int {
    return this.fold(0) { acc, x -> acc + (1 shl x) }
}

fun List<Int>.decrementIndices(indices: List<Int>): List<Int> {
    val ret = this.toMutableList()
    for (i in indices) ret[i]--
    return ret
}
