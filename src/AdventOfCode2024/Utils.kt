package AdventOfCode2024

import kotlin.math.cos
import kotlin.math.sin


fun Pair<Int, Int>.rotateDeg(deg: Double): Pair<Int, Int> {
    return this.rotate(Math.toRadians(deg))
}

fun Pair<Int, Int>.rotate(rads: Double): Pair<Int, Int> {
    val x = this.first
    val y = this.second

    return (x * cos(rads) - y * sin(rads)).toInt() to (x * sin(rads) + y * cos(rads)).toInt()
}
