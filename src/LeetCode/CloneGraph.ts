/**
 * Definition for _Node.
 * class _Node {
 *     val: number
 *     neighbors: _Node[]
 *
 *     constructor(val?: number, neighbors?: _Node[]) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.neighbors = (neighbors===undefined ? [] : neighbors)
 *     }
 * }
 *
 */


function cloneGraph(node: _Node | null): _Node | null {
    if (node === null) return null;

    const cache: Record<number, _Node> = {};
    return innerClone(cache, node);
}

function innerClone(cache: Record<number, _Node>, node: _Node) {
    if (!cache[node.val]) {
        cache[node.val] = new _Node(node.val);
        cache[node.val].neighbors = node.neighbors.map(n => innerClone(cache, n));
    }

    return cache[node.val];
}
