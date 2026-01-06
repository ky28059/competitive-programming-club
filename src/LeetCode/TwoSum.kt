class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            if (map[num] != null) {
                return intArrayOf(i, map[num]!!)
            }
            map[target - num] = i
        }

        return intArrayOf()
    }
}
