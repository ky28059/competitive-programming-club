package AdventOfCode2021


// Day 4 input, split into:
// - The sequential list of numbers to be called, given as an Int[]
// [1, 23, 4, 37, ...]
//
// - The list of bingo boards, with each board represented as an Int[][]
// [[[22, 13, 17, 11, 0],
//   [8, 2, 23, 4, 24],
//   [21, 9, 14, ...],
//   ...],
//  ...]
val day4Numbers = day4[0].split(",").map { it.toInt() }
val day4Boards = day4.drop(1)
    .map { board -> board.split(Regex("\r?\n")) // Split board by newlines
        .map { line -> line.trim().split(Regex("\\s+")) // Split each line by whitespace
            .map { it.toInt() } } }

fun main() {
    val numbers = mutableSetOf<Int>()
    outer@ for (i in day4Numbers) {
        numbers.add(i)

        for (board in day4Boards) {
            val value = checkBoard(board, numbers)
            if (value != -1L) {
                println(value * i)
                break@outer
            }
        }
    }
}

// Check a board to see if it won, given the board, the called numbers (including the just called one),
// and the just called number, returning the sum of the unmatched numbers of the board if it won and -1 otherwise.
fun checkBoard(board: List<List<Int>>, numbers: Set<Int>): Long {
    // Rows || Columns
    if (board.any { numbers.containsAll(it) } || board.indices.any { i -> numbers.containsAll(board.map { it[i] }) })
        return board.sumOf { it.fold(0L) { sum, i -> sum + if (numbers.contains(i)) 0 else i } }

    return -1
}
