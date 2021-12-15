package AdventOfCode2021


fun main() {
    val fish = LongArray(9)
    for (i in day6) fish[i]++

    for (i in 0 until 256) {
        val tempFish = fish.clone()

        for (j in 0..7)
            fish[j] = tempFish[j + 1]

        fish[6] += tempFish[0]
        fish[8] = tempFish[0]
    }

    println(fish.sum())
}
