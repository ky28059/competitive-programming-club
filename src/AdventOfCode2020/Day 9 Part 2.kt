package AdventOfCode2020


fun main() {
    val invalid = getInvalid()

    //val sums = day9.map { it.toLong() }.toMutableList()
    //var sum: Long = 0

    //for (i in day9.indices) {
    //    sum += day9[i].toLong()
    //    sums[i] = sum
    //}

    for (i in day9.indices) {
        for (k in (i + 1) until day9.size) {
            val subList = day9.slice(i..k).map{ it.toLong() }.toMutableList()
            subList.sort()

            val listSum = subList.reduce { a, b -> a + b }
            if (listSum == invalid) return println(subList[0] + subList[subList.size - 1])
        }
    }
}