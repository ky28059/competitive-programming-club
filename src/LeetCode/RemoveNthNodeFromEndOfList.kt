/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null

        var i = 0
        var node = head
        var beforeNode = head
        var afterNode = head.next

        // Make one pass through the linked list, "dragging" a pointer to the current node, the (n + 1)th node from the
        // current node, and the (n - 1)th node from the current node.
        while (node!!.next != null) {
            node = node.next
            if (i++ >= n) beforeNode = beforeNode!!.next
            if (i >= n) afterNode = afterNode?.next
        }

        // If the list was not long enough to "drag" the pointer n times, that means the head of the list is the element
        // being removed; return the second element to remove it.
        if (i < n) return afterNode

        // Otherwise, set the node before the removed index to point to the node after the removed index to remove it.
        beforeNode!!.next = afterNode
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
