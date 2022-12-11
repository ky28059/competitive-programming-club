package AdventOfCode2022


fun main() {
    println(day2.sumBy { (o, y) ->
        when (y) {
            "X" -> 1
            "Y" -> 2
            else -> 3
        } + when {
            (o == "A" && y == "Z") || (o == "B" && y == "X") || (o == "C" && y == "Y") -> 0 // Loss
            (o == "A" && y == "X") || (o == "B" && y == "Y") || (o == "C" && y == "Z") -> 3 // Draw
            else -> 6 // Win
        }
    })
}
