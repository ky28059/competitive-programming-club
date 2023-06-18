class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val index = nums.binarySearch(target)
        return if (index < 0) -index - 1 else index
    }
}
