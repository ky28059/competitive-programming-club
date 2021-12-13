package AdventOfCode2021

import kotlin.math.max
import kotlin.math.min


fun main() {
    val arr = Array(1000) { IntArray(1000) }

    for ((left, right) in day5) {
        val (x1, y1) = left.split(",").map { it.toInt() }
        val (x2, y2) = right.split(",").map { it.toInt() }

        if (x1 == x2) {
            for (row in min(y1, y2)..max(y1, y2)) arr[row][x1]++
        } else if (y1 == y2) {
            for (col in min(x1, x2)..max(x1, x2)) arr[y1][col]++
        } else {
            for (row in min(y1, y2)..max(y1, y2))
                for (col in min(x1, x2)..max(x1, x2))
                    if (row - y1 == col - x1 || row + col == x1 + y1) arr[row][col]++
        }
    }

    //println(arr.joinToString("") { it.joinToString("") { count -> if (count == 0) "." else count.toString() } + "\n" })
    println(arr.sumBy { row -> row.count { it > 1 } })
}
