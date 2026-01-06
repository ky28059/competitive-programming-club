function climbStairs(n: number): number {
    if (n === 1) return 1;

    let curr = 2;
    let prev = 1;

    for (let i = 3; i <= n; i++) {
        const next = curr + prev;
        prev = curr;
        curr = next;
    }

    return curr;
}
