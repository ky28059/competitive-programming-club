/**
 Do not return anything, modify nums in-place instead.
 */
function sortColors(nums: number[]): void {
    // `rPtr` points to the index after the last red elem, `wPtr` index after last white elem
    let rPtr = 0;
    let wPtr = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) { // Swap curr w/ elem after last white, then w/ elem after last red
            nums[i] = nums[wPtr];
            nums[wPtr] = nums[rPtr];
            nums[rPtr] = 0;
            rPtr++;
            wPtr++;
        } else if (nums[i] === 1) { // Swap curr w/ elem after last white
            nums[i] = nums[wPtr];
            nums[wPtr] = 1;
            wPtr++;
        }
    }
}
