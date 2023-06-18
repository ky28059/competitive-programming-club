function plusOne(digits: number[]): number[] {
    let i = digits.length - 1;
    digits[i]++;

    while (digits[i] === 10) {
        digits[i--] = 0;
        if (i < 0) return [1, ...digits];
        digits[i]++;
    }

    return digits;
}
