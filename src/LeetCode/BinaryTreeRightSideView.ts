/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function rightSideView(root: TreeNode | null): number[] {
    const ret = [];
    inOrderByLevel(root, ret);
    return ret;
}

/**
 * DFS solution
 */
function inOrderByLevel(node: TreeNode | null, visited: number[], level: number = 0) {
    if (node === null) return;

    inOrderByLevel(node.right, visited, level + 1);

    if (visited[level] === undefined) {
        visited[level] = node.val;
    }

    inOrderByLevel(node.left, visited, level + 1);
}
