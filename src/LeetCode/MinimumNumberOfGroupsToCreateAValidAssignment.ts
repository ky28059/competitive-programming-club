function minGroupsForValidAssignment(balls: number[]): number {
    const freqs: Record<number, number> = {};
    for (const b of balls) {
        if (!freqs[b]) freqs[b] = 0;
        freqs[b]++;
    }

    const counts = Object.values(freqs);

    let min = Math.min(...counts);
    let curr = 0;

    for (let i = 0; i < counts.length; i++) {
        const maxBoxes = Math.floor(counts[i] / min);
        const minBoxes = Math.ceil(counts[i] / (min + 1));

        // There's not enough boxes to consume the remainder, we have to reset lower
        if (counts[i] % min > maxBoxes) {
            min = Math.floor(counts[i] / (maxBoxes + 1));
            i = -1;
            curr = 0;
            continue;
        }

        curr += minBoxes;
    }

    return curr;
}
