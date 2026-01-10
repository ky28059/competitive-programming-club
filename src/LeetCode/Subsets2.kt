class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        return (0 until 1.shl(nums.size)).map { nums.filterIndexed { i, _ -> it and (1 shl i) != 0 } }
    }
}
