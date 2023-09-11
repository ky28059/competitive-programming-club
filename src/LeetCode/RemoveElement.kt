class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var writeIndex = 0

        for (i in nums.indices) {
            if (nums[i] == `val`) continue
            nums[writeIndex++] = nums[i]
        }

        return writeIndex
    }
}
