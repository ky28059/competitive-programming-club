class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {number}
     */
    countComponents(n, edges) {
        const adjList = {};
        for (const [a, b] of edges) {
            if (!adjList[a]) adjList[a] = [];
            if (!adjList[b]) adjList[b] = [];
            adjList[a].push(b);
            adjList[b].push(a);
        }

        const unexplored = new Set(Array(n).fill(0).map((_, i) => i));

        let count = 0;
        while (unexplored.size > 0) {
            bfs(unexplored, adjList)
            count++;
        }

        return count;
    }
}

function bfs(unexplored, adjList) {
    const node = unexplored.values().next().value; // Just explore the first
    const queue = [node];

    while (queue.length > 0) {
        const u = queue.shift();
        unexplored.delete(u);

        if (!adjList[u]) continue;

        for (const v of adjList[u]) {
            if (unexplored.has(v))
                queue.push(v);
        }
    }
}
