package AdventOfCode2019


val day8Layers = day8.chunked(25 * 6)

fun main() {
    val layer = day8Layers.minByOrNull { it.count { a -> a == 0 } }!!
    println(layer.count { it == 1 } * layer.count { it == 2 })
}
