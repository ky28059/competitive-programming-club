package AdventOfCode2021


fun main() {
    val numbers = mutableSetOf<Int>()
    val indices = mutableSetOf<Int>()
    var last = 0L

    for (i in day4Numbers) {
        numbers.add(i)

        for ((j, board) in day4Boards.withIndex()) {
            val value = checkBoard(board, numbers)
            if (value != -1L) {
                if (indices.contains(j)) continue
                indices.add(j)
                last = value * i
            }
        }
    }
    println(last)
}
