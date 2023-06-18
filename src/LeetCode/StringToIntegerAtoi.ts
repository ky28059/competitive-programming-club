function myAtoi(s: string): number {
    const num = parseInt(s.match(/^\s*([-+]?\d*)/)?.[1]) || 0;
    return Math.min(Math.max(num, -(2 ** 31)), 2 ** 31 - 1);
}
