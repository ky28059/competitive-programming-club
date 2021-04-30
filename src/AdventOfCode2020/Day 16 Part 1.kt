package AdventOfCode2020

import java.util.*


val validRanges: List<List<String>> = day16[0]
    .split(System.lineSeparator())
    .map { it.split(": ") }

val rangesTable: Hashtable<String, List<IntRange>> = populateRangesTable()

val yourTicket: List<Int> = day16[1]
    .replace("your ticket:${System.lineSeparator()}", "")
    .split(",")
    .map { it.toInt() }

val nearbyTickets: List<List<Int>> = day16[2]
    .split(System.lineSeparator())
    .drop(1)
    .map { it.split(",").map { x -> x.toInt() } }


fun populateRangesTable(): Hashtable<String, List<IntRange>> {
    val table = Hashtable<String, List<IntRange>>()
    for ((name, ranges) in validRanges) {
        val r: List<IntRange> = ranges
            .split(" or ")
            .map { it.split("-").map { x -> x.toInt() } }
            .map { (min, max) -> min.rangeTo(max) }
        table[name] = r
    }
    return table
}

fun main() {
    var errorRate = 0

    for (ticket in nearbyTickets) {
        for (field in ticket) {
            var possible = false
            for ((_, ranges) in rangesTable) {
                for (range in ranges) {
                    if (field in range) possible = true
                }
            }

            if (!possible) errorRate += field
        }
    }

    println(errorRate)
}