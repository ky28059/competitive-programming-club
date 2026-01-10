function canPartition(nums: number[]): boolean {
    const target = nums.reduce((a, b) => a + b, 0) / 2;
    if (target % 1 !== 0) return false;

    // Knapsack DP s.t. dp[n][w] = true if there exists a subset of nums[0..n] that sums to w
    const dp = Array(nums.length).fill(0).map(_ => Array(target + 1).fill(false));

    for (let n = 0; n < nums.length; n++) {
        for (let w = 0; w <= target; w++) {
            if (w === 0) {
                dp[n][w] = true;
            } else if (n === 0 && w === nums[n]) {
                dp[n][w] = true;
            } else if (n > 0) {
                dp[n][w] = dp[n - 1][w];

                if (w >= nums[n])
                    dp[n][w] = dp[n][w] || dp[n - 1][w - nums[n]];
            }
        }
    }

    return dp[nums.length - 1][target];
}
