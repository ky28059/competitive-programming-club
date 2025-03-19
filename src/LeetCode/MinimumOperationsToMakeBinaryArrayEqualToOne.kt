class Solution {
    fun minOperations(nums: IntArray): Int {
        var count = 0

        // Sweep left to right; for each 0, we *must* flip it and the next 2 elements (since the elements
        // to the left are already correct).
        for (i in nums.indices) {
            if (nums[i] == 1) continue

            // If one of the last 2 elements is a 0, it's impossible to fix.
            if (i >= nums.size - 2) return -1

            nums[i + 1] = (nums[i + 1] + 1) % 2
            nums[i + 2] = (nums[i + 2] + 1) % 2
            count++
        }

        return count
    }
}
