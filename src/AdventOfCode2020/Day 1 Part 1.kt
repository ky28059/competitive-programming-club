package AdventOfCode2020


fun main() {
    val arr = day1.split(' ').map { it.toInt() }

    for (i in arr.indices) {
        // Hacky solution to double nest the for loop and loop through all possible sums
        for (k in i until arr.size) {
            if (arr[i] + arr[k] == 2020) {
                println(arr[i] * arr[k])
            }
        }
    }
}