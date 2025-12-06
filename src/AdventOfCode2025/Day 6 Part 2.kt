package AdventOfCode2025


fun main() {
    val ops = day6.last().trim().split(Regex("\\s+"))

    // Split at each index such that *all* columns have spaces in that index
    val splitAt = day6[0].indices.filter { i -> day6.all { it[i] == ' ' } }
    val cells = day6.dropLast(1).map { it.splitAtIndices(splitAt) }

    val vals = cells[0].indices
        .map { j -> cells.indices.map { i -> cells[i][j] } }
        .map { cephalopodNumber(it) }

    println(vals.indices.sumOf { j ->
        if (ops[j] == "*")
            vals[j].fold(1L) { sum, v -> sum * v }
        else
            vals[j].fold(0L) { sum, v -> sum + v }
    })
}

fun String.splitAtIndices(indices: List<Int>): List<String> {
    val ret = mutableListOf<String>()

    var curr = 0
    for (i in indices) {
        ret.add(this.slice(curr until i))
        curr = i + 1
    }
    ret.add(this.slice(curr until this.length))
    return ret
}

fun cephalopodNumber(nums: List<String>): List<Long> {
    val max = nums.maxOf { s -> s.length } - 1

    return (max downTo 0).map { i ->
        nums.fold(0L) { acc, s -> if (s.length <= i || s[i] == ' ') acc else acc * 10 + s[i].digitToInt() }
    }
}
