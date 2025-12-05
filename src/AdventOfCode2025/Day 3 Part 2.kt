package AdventOfCode2025

import kotlin.math.pow


fun main() {
    println(day3.sumOf {
        val dp = Array(11) { i -> LongArray(it.length - (i + 1)) }

        for (l in dp.indices) {
            for (c in it.indices.reversed().drop(l + 1)) {
                if (l == 0)
                    dp[l][c] = dp[l][c].coerceAtLeast(it[c + 1].digitToInt().toLong())
                else
                    dp[l][c] = dp[l][c].coerceAtLeast(it[c + 1].digitToInt() * (10.0).pow(l).toLong() + dp[l - 1][c + 1])
                if (c < it.length - 2 - l)
                    dp[l][c] = dp[l][c].coerceAtLeast(dp[l][c + 1])
            }
        }

        it.dropLast(11).withIndex().maxOf {
            (i, c) -> c.digitToInt() * (10.0).pow(11).toLong() + dp[10][i]
        }
    })
}
