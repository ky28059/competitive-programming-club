package AdventOfCode


fun main() {
    // I map to longs because I thought there might've been integer overflow and now I am too lazy to change back
    val arr = day1.split(' ').map { it.toLong() }

    var i = 0;
    while (i < arr.size) {
        val value = arr[i]
        val after = arr.subList(i, arr.size)

        // Hacky solution to double nest the for loop and loop through all possible sums
        for (k in after) {
            if (value + k == 2020.toLong()) {
                println(value * k)
            }
        }

        i++
    }
}