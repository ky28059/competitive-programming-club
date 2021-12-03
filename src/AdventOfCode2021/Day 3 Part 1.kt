package AdventOfCode2021


fun main() {
    val store = BitStore(day3[0].length, day3.size)

    for (bitStr in day3) {
        for (i in bitStr.indices) {
            store.inc(i, bitStr[i].toString().toInt())
        }
    }

    var gamma = 0
    var epsilon = 0
    for (i in 0 until store.size) {
        if (store.isMajorityOne(i)) {
            gamma = (gamma + 1) shl 1
            epsilon = epsilon shl 1
        } else {
            epsilon = (epsilon + 1) shl 1
            gamma = gamma shl 1
        }
    }
    // Correct for overshifting
    gamma = gamma shr 1
    epsilon = epsilon shr 1

    println(gamma * epsilon)
}

// Not an ideal implementation
data class BitStore(val size: Int, val bitCount: Int) {
    private val backing = IntArray(size)

    fun inc(bit: Int, value: Int) {
        if (value == 1) backing[bit]++
    }
    fun isMajorityOne(bit: Int): Boolean {
        return backing[bit] > bitCount / 2
    }
}
