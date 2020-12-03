package AdventOfCode

fun main() {
    val arr = day1.split(' ').map { it.toInt() }

    var i = 0;
    while (i < arr.size) {
        val value = arr[i]
        val after = arr.subList(i, arr.size)

        // The hackiest solution of all time, the triple for loop
        var k = 0
        while (k < after.size) {
            val value2 = after[k]
            val afterer = after.subList(k, after.size)

            // Perhaps a part 3 with 4 numbers can have an array called aftererest
            for (j in afterer) {
                if (value + value2 + j == 2020) {
                    println(value * value2 * j)
                }
            }

            k++
        }

        i++
    }
}