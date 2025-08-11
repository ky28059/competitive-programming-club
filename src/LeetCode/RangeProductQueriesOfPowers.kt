class Solution {
    fun getPowers(n: Int): MutableList<Int> {
        var curr = n
        var i = 0
        val powers = mutableListOf<Int>()

        // The powers array of an integer n is just its bitwise representation
        while (curr > 0) {
            if (curr and 1 == 1) powers.add(i)
            curr = curr shr 1
            i++
        }

        return powers
    }

    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val powers = getPowers(n)
        val prefixPowers = IntArray(powers.size)

        // Populate prefix sums array of exponents
        prefixPowers[0] = powers[0]
        for (i in 1 until powers.size) {
            prefixPowers[i] = powers[i] + prefixPowers[i - 1]
        }

        val ret = IntArray(queries.size)

        for (i in queries.indices) {
            val (l, r) = queries[i]
            val ansPow = if (l > 0) prefixPowers[r] - prefixPowers[l - 1] else prefixPowers[r]

            ret[i] = powmod(2, ansPow, 1_000_000_007)
        }

        return ret
    }

    fun powmod(base: Int, exp: Int, m: Int): Int {
        if (m == 1) return 0
        var res = 1L
        var b = (base % m).toLong()
        var e = exp

        while (e > 0) {
            if (e % 2 == 1) res = (res * b) % m
            b = (b * b) % m
            e /= 2
        }
        return res.toInt()
    }
}
