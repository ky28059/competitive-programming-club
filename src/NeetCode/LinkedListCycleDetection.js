/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {boolean}
     */
    hasCycle(head) {
        let t = head.next;
        let h = head.next?.next;

        while (true) {
            if (!t || !h) return false;
            if (t === h) return true;

            t = t.next;
            h = h.next?.next;
        }
    }
}
