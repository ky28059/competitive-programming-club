package AdventOfCode2025

import java.lang.Integer.max


fun main() {
    println(day3.sumOf {
        val maxAfter = IntArray(it.length - 1)

        for (c in it.indices.reversed()) {
            if (c == it.length - 1) continue
            if (c == it.length - 2) {
                maxAfter[c] = it[c + 1].digitToInt()
                continue
            }

            maxAfter[c] = max(maxAfter[c + 1], it[c + 1].digitToInt())
        }

        it.dropLast(1).withIndex().maxOf { (i, c) -> c.digitToInt() * 10 + maxAfter[i] }
    })
}
