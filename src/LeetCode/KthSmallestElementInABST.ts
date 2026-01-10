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

function kthSmallest(root: TreeNode | null, k: number): number {
    const sorted = [];
    inOrder(root, sorted);
    return sorted[k - 1];
}

function inOrder(node: TreeNode | null, ret: number[]) {
    if (!node) return;

    inOrder(node.left, ret);
    ret.push(node.val);
    inOrder(node.right, ret);
}
