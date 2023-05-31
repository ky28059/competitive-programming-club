package AdventOfCode2020


fun main() {
    var sums = 0

    for (group in day6) {
        val questions = mutableSetOf<Char>()

        for (person in group) {
            person.forEach { questions.add(it) }
        }

        sums += questions.size
    }
    println(sums)
}
