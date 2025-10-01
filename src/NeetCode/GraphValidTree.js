class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {boolean}
     */
    validTree(n, edges) {
        if (edges.length !== n - 1) return false;

        const uf = Array(n).fill(0).map((_, i) => i);

        for (const [s, t] of edges) {
            // If s and t are already connected, there is a cycle
            // -> not a tree.
            if (uf[s] === uf[t]) return false;

            // Connect s and t in uf
            if (uf[t] > uf[s]) {
                uf[t] = uf[s];
            } else {
                uf[s] = uf[t];
            }
        }

        // Make sure all remaining nodes are connected
        for (let i = 1; i < n; i++) {
            if (uf[0] !== uf[i]) return false;
        }

        return true;
    }
}
