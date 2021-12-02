package AdventOfCode2020


fun main() {
    for (i in day1.indices) {
        for (k in i until day1.size) {
            for (j in k until day1.size) {
                if (day1[i] + day1[k] + day1[j] == 2020) {
                    println(day1[i] * day1[k] * day1[j])
                }
            }
        }
    }
}
