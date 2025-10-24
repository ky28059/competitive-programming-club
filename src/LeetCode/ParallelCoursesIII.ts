function minimumTime(n: number, relations: number[][], time: number[]): number {
    const inDeg = Array(n).fill(0);
    const adjList = Array(n).fill(0).map(_ => []);

    const finish = Array(n).fill(0);
    let m = 0;

    // Set up DAG
    for (const [from, to] of relations) {
        inDeg[to - 1]++;
        adjList[from - 1].push(to - 1);
    }

    // Process nodes in topological order
    const queue = Array(n).fill(0).map((_, i) => i).filter(i => inDeg[i] === 0);

    while (queue.length > 0) {
        const head = queue.shift();

        finish[head] += time[head];
        m = Math.max(m, finish[head]);

        for (const s of adjList[head]) {
            finish[s] = Math.max(finish[s], finish[head]);

            inDeg[s]--;
            if (inDeg[s] === 0) queue.push(s);
        }
    }

    return m;
}
