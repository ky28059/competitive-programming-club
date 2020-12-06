package AdventOfCode

fun main() {
    var sums = 0

    for (group in day6) {
        val questions = mutableListOf<Char>()
        for (person in group) {
            person.forEach { questions.add(it) }
        }

        val inCommon = mutableSetOf<Char>()
        for (question in questions) {
            if (questions.filter { it == question}.size == group.size) inCommon.add(question)
        }

        sums += inCommon.size
    }
    println(sums)
}