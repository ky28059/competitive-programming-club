/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {number}
     */
    goodNodes(root) {
        return countGood(root, -200); // or -INF
    }
}

function countGood(root, m) {
    let count = root.val >= m ? 1 : 0;

    const max = Math.max(m, root.val);
    if (root.left) count += countGood(root.left, max);
    if (root.right) count += countGood(root.right, max);

    return count;
}
