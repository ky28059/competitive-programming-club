function insert(intervals: number[][], newInterval: number[]): number[][] {
    const ret = [];

    const curr = newInterval;
    let passed = false;

    for (const interval of intervals) {
        // Interval completely before the current one
        if (interval[1] < curr[0]) {
            ret.push(interval);
            continue;
        }

        // Interval completely after the current one
        if (passed || interval[0] > curr[1]) {
            if (!passed) ret.push(curr);
            ret.push(interval);
            passed = true;
            continue;
        }

        // Otherwise, there's overlap
        if (interval[0] < curr[0])
            curr[0] = interval[0];
        if (interval[1] > curr[1])
            curr[1] = interval[1];
    }

    if (!passed)
        ret.push(curr);

    return ret;
}
