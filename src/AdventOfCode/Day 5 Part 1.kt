package AdventOfCode

import kotlin.math.ceil


fun calcSeatID(pass: String): Int {
    var rowMin = 0
    var rowMax = 127

    for (i in 0..6) {
        val diff = (rowMax - rowMin).toDouble()
        when (pass[i]) {
            // Ceil both diffs because integer division
            'F' -> rowMax -= ceil(diff / 2).toInt() // Set max to halfway between oldmin and oldmax
            'B' -> rowMin += ceil(diff / 2).toInt() // Set min to halfway between oldmin and oldmax
        }
    }
    if (rowMax != rowMin) println("Error parsing rows") // Quick check to make sure the operations have finished properly


    var colMin = 0
    var colMax = 7

    for (j in 7..9) {
        val diff = (colMax - colMin).toDouble()
        when (pass[j]) {
            // Ceil both diffs because integer division
            'L' -> colMax -= ceil(diff / 2).toInt() // Set max to halfway between oldmin and oldmax
            'R' -> colMin += ceil(diff / 2).toInt() // Set min to halfway between oldmin and oldmax
        }
    }
    if (colMax != colMin) println("Error parsing columns") // Quick check to make sure the operations have finished properly

    return rowMin * 8 + colMin
}

fun main() {
    var max = 0

    for (pass in day5) {
        val seatID = calcSeatID(pass)
        if (seatID > max) max = seatID
    }
    println(max)
}