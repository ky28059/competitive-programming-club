package AdventOfCode2022


fun main() {
    println(day2.sumOf { (o, r) ->
        when (r) {
            "X" -> 0
            "Y" -> 3
            else -> 6
        } + when {
            (r == "X" && o == "B") || (r == "Y" && o == "A") || (r == "Z" && o == "C") -> 1 // Rock
            (r == "X" && o == "C") || (r == "Y" && o == "B") || (r == "Z" && o == "A") -> 2 // Paper
            else -> 3 // Scissors
        }
    })
}
