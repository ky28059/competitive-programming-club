package AdventOfCode2020


fun main() {
    println(day2.count { checkSledPassword(it) })
}

// Checks a pass `range letter: password` for whether the password contains a count of the given letter
// within the allowed range.
fun checkSledPassword(pass: String): Boolean {
    val (policy, password) = pass.split(": ")
    val (numAllowed, letter) = policy.split(" ")
    val (min, max) = numAllowed.split("-").map { it.toInt() }

    val occurrences = password.count { it == letter[0] }
    return occurrences in min..max
}
