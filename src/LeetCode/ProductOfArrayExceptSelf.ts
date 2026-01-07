function productExceptSelf(nums: number[]): number[] {
    const ret = Array(nums.length).fill(1);

    // Apply prefix multiplications
    for (let i = 0; i < nums.length - 1; i++) {
        ret[i + 1] *= nums[i];
        ret[i + 1] *= ret[i];
    }

    // Apply suffix multiplications
    let suffix = 1;
    for (let i = nums.length - 1; i > 0; i--) {
        suffix *= nums[i];
        ret[i - 1] *= suffix;
    }

    return ret;
}
