class Solution {
    /**
     * @param {number[]} numbers
     * @param {number} target
     * @return {number[]}
     */
    twoSum(numbers, target) {
        const remainders = {};

        for (let i = 0; i < numbers.length; i++) {
            const r = target - numbers[i];

            if (remainders[r] !== undefined)
                return [remainders[r] + 1, i + 1];

            remainders[numbers[i]] = i;
        }
    }
}
