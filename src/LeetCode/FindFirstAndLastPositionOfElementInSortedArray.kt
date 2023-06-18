class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = nums.binarySearch(target)
        if (index < 0) return intArrayOf(-1, -1)

        var lower = index
        while (lower >= 0 && nums[lower] == target) lower--

        var upper = index
        while (upper < nums.size && nums[upper] == target) upper++

        return intArrayOf(lower + 1, upper - 1)
    }
}
