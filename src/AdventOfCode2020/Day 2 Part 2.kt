package AdventOfCode2020


fun main() {
    println(day2.count { checkTobogganPassword(it) })
}

// Checks a pass `range letter: password` for whether the password contains the given letter exactly once between
// the two indices specified by the range.
fun checkTobogganPassword(pass: String): Boolean {
    val (policy, password) = pass.split(": ")
    val (indices, letter) = policy.split(" ")
    val (leftIndex, rightIndex) = indices.split("-").map { it.toInt() }

    val left = password[leftIndex - 1]
    val right = password[rightIndex - 1]

    // One of the indices must be the given letter, but not both
    return (left == letter[0] || right == letter[0]) && left != right
}
