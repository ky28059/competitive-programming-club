class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    rob(nums) {
        if (nums.length === 1) return nums[0];

        const one = this.maxNonAdjacent(nums.slice(0, -1));
        const two = this.maxNonAdjacent(nums.slice(1));

        return Math.max(one, two);
    }

    maxNonAdjacent(arr) {
        const dp = Array(arr.length + 1).fill(0);
        // dp[arr.length] = 0;
        dp[arr.length - 1] = arr.at(-1);

        for (let i = arr.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], arr[i] + dp[i + 2]);
        }

        return dp[0];
    }
}
