class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, MutableSet<Int>>()

        for (i in nums.indices) {
            val num = nums[i]
            if (map[target - num] == null) map[target - num] = mutableSetOf()
            map[target - num]!!.add(i)
        }

        for (i in nums.indices) {
            val num = nums[i]
            map[num]?.remove(i)

            val index = map[num]?.firstOrNull()
            if (index != null) return intArrayOf(i, index)

            map[num]?.add(i)
        }

        return intArrayOf()
    }
}
