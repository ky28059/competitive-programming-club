class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var curr = nums[0]
        var writeIndex = 1

        for (i in 1 until nums.size) {
            if (nums[i] == curr) continue
            nums[writeIndex++] = nums[i]
            curr = nums[i]
        }

        return writeIndex
    }
}
