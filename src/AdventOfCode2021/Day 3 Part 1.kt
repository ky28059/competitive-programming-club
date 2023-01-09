package AdventOfCode2021


fun main() {
    val (gamma, epsilon) = getGammaEpsilon(day3)
    println(gamma.toInt(2) * epsilon.toInt(2))
}

// Returns a pair of strings (gamma, epsilon) for the given list input
// Defaults to breaking ties favoring '1', pass false to `preferOne` to favor '0'
fun getGammaEpsilon(src: List<String>, preferOne: Boolean = true): Pair<String, String> {
    val store = BitStore(src[0].length, src.size)

    for (bitStr in src) {
        for (i in bitStr.indices) {
            store.inc(i, bitStr[i].digitToInt())
        }
    }

    var gamma = ""
    var epsilon = ""
    for (i in 0 until store.size) {
        if (store.isMajorityOne(i, preferOne)) {
            gamma += "1"
            epsilon += "0"
        } else {
            epsilon += "1"
            gamma += "0"
        }
    }
    return gamma to epsilon
}

// Not an ideal implementation
data class BitStore(val size: Int, val bitCount: Int) {
    private val backing = IntArray(size)

    fun inc(bit: Int, value: Int) {
        if (value == 1) backing[bit]++
    }
    fun isMajorityOne(bit: Int, preferOne: Boolean): Boolean {
        return if (preferOne) backing[bit] > bitCount / 2
            else backing[bit] >= bitCount / 2
    }
}
