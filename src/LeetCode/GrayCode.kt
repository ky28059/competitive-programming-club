class Solution {
    fun grayCode(n: Int): List<Int> {
        if (n == 1) return listOf(0, 1)

        val prev = grayCode(n - 1)
        return prev + prev.reversed().map { it + (1 shl (n - 1)) }
    }
}
