class Solution {
    /**
     * @param {string} S
     * @return {number[]}
     */
    partitionLabels(S) {
        const lastIndex = {};
        for (let i = 0; i < S.length; i++) {
            lastIndex[S[i]] = i;
        }

        // Iterate through the string; each time we see a char c, we need to
        // extend the current partition until at least the last occurrence of c.
        const partitions = [];

        let start = 0;
        let end = 0;

        for (let i = 0; i < S.length; i++) {
            end = Math.max(end, lastIndex[S[i]]);

            if (i === end) {
                partitions.push(end - start + 1);
                start = i + 1;
            }
        }

        return partitions;
    }
}
