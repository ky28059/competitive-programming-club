import kotlin.math.roundToInt

// Novice Question B
// (Not part of advance contest, submitted afterwards for fun)
fun main() {
    val average = readln()
        .dropLast(1)
        .split(Regex("[.?!]"))
        .map { it.trim().split(" ").size }
        .average()
        .roundToInt()
    println(average)
}
