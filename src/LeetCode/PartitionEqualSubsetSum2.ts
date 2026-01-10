function canPartition(nums: number[]): boolean {
    const target = nums.reduce((a, b) => a + b, 0) / 2;
    if (target % 1 !== 0) return false;

    // dp[w] = true if there exists a subset of nums that sums to w
    const dp = Array(target + 1).fill(false);
    dp[0] = true;

    for (let i = 0; i < nums.length; i++) {
        for (let j = target - nums[i]; j >= 0; j--) {
            if (!dp[j]) continue;
            if (target === j + nums[i]) return true;

            dp[j + nums[i]] = true;
        }
    }

    return false;
}
