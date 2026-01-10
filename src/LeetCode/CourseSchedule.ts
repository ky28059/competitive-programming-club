function canFinish(numCourses: number, prerequisites: number[][]): boolean {
    const adjList = Array(numCourses).fill(0).map(_ => []);
    const inDegs = Array(numCourses).fill(0);

    for (const [u, v] of prerequisites) {
        adjList[v].push(u);
        inDegs[u]++;
    }

    const queue = inDegs.map((_, i) => i).filter((_, i) => inDegs[i] === 0);

    for (let i = 0; i < numCourses; i++) {
        const head = queue[i];
        if (head === undefined) return false;

        for (const n of adjList[head]) {
            inDegs[n]--;

            if (inDegs[n] === 0)
                queue.push(n);
        }
    }

    return true;
}
