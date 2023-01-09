package AdventOfCode2019


fun main() {
    val image = (0 until 25 * 6).map { getPixel(it) }
    println(image.chunked(25).joinToString("\n") { it.joinToString("") { a -> if (a == 0) "#" else "." } })
}

// Recursively gets the ith pixel of the image, starting at the first layer and falling through to layers underneath
// on transparent pixels.
tailrec fun getPixel(i: Int, layer: Int = 0): Int {
    return when (val pixel = day8Layers[layer][i]) {
        0, 1 -> pixel
        else -> getPixel(i, layer + 1)
    }
}
