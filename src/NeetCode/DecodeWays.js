class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    numDecodings(s) {
        const dp = Array(s.length + 1).fill(0);
        dp[s.length] = 1;
        dp[s.length - 1] = s.at(-1) === '0' ? 0 : 1;

        for (let i = s.length - 2; i >= 0; i--) {
            if ((s[i] === '1') || (s[i] === '2' && s[i + 1] <= '6')) {
                dp[i] = dp[i + 1] + dp[i + 2];
                continue;
            }

            // Special handling for '0' edge case
            if (s[i] === '0') {
                if (i === 0 || (s[i - 1] !== '1' && s[i - 1] !== '2')) return 0;
                continue;
            }

            dp[i] = dp[i + 1];
        }

        return dp[0];
    }
}
