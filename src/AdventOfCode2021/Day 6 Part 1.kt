package AdventOfCode2021


fun main() {
    val fish = day6.toMutableList()

    for (i in 0 until 80) {
        for (j in fish.indices) {
            if (fish[j] == 0) {
                fish.add(8)
                fish[j] = 6
            } else fish[j]--
        }
    }

    println(fish.size)
}
