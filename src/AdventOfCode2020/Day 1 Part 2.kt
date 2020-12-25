package AdventOfCode2020

fun main() {
    val arr = day1.split(' ').map { it.toInt() }

    // The hackiest solution of all time, the triple for loop
    for (i in arr.indices) {
        for (k in i until arr.size) {
            for (j in k until arr.size) {
                if (arr[i] + arr[k] + arr[j] == 2020) {
                    println(arr[i] * arr[k] * arr[j])
                }
            }
        }
    }
}