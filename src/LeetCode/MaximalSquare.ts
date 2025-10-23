function maximalSquare(matrix: string[][]): number {
    const dp = matrix.map(r => r.map(c => 0));
    let m = 0;

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] === '0')
                dp[i][j] = 0;
            else if (i === 0 || j === 0)
                dp[i][j] = 1;
            else
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;

            m = Math.max(m, dp[i][j]);
        }
    }

    return m * m;
}
