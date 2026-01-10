function uniquePaths(m: number, n: number): number {
    // The number of paths is the number of permutations of the string
    // ("D" * (n - 1)) + ("R" * (m - 1)) which is (n + m - 2)! / (n - 1)!(m - 1)!
    return Math.round(fact(n + m - 2, n) / fact(m - 1));
}

function fact(n: number, from: number = 2) {
    let res = 1;
    for (let i = from; i <= n; i++) {
        res *= i;
    }
    return res;
}
