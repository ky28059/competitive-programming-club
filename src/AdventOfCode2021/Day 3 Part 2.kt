package AdventOfCode2021


fun main() {
    var oxyRating = 0
    var co2Rating = 0

    var (gamma, epsilon) = getGammaEpsilon(day3)

    var filtered = day3
    for (i in gamma.indices) {
        //println("[$i] ${gamma[i]}: $filtered")
        if (filtered.size == 1) {
            oxyRating = filtered[0].toInt(2)
            break
        }
        // If we've run out of bits to compare, break ties by preferring 1
        if (i == gamma.length - 1) {
            oxyRating = filtered.first { it[i] == '1' }.toInt(2)
            break
        }

        val temp = filtered.filter { it[i] == gamma[i] }
        if (temp.isEmpty()) continue

        filtered = temp
        gamma = getGammaEpsilon(filtered).first
    }

    filtered = day3
    for (i in epsilon.indices) {
        //println("[$i] ${epsilon[i]}: $filtered")
        if (filtered.size == 1) {
            co2Rating = filtered[0].toInt(2)
            break
        }
        // If we've run out of bits to compare, break ties by preferring 0
        if (i == epsilon.length - 1) {
            co2Rating = filtered.first { it[i] == '0' }.toInt(2)
            break
        }

        val temp = filtered.filter { it[i] == epsilon[i] }
        if (temp.isEmpty()) continue

        filtered = temp
        epsilon = getGammaEpsilon(filtered, false).second
    }

    //println(oxyRating)
    //println(co2Rating)
    println(oxyRating * co2Rating)
}
