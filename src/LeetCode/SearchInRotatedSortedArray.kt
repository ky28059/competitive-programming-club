class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val rotated = nums[0] > nums[nums.size - 1]

        if (rotated && nums[0] > target) {
            for (i in nums.size - 1 downTo 0) when {
                nums[i] == target -> return i
                nums[i] < target -> return -1
            }
        } else {
            for (i in nums.indices) when {
                nums[i] == target -> return i
                nums[i] > target -> return -1
            }
        }

        return -1
    }
}
