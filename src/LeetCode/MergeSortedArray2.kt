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
    // No pair destructuring, ~13ms faster
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val head = if (list1.`val` < list2.`val`) {
            list1
        } else {
            list2
        }

        val other = if (list1.`val` < list2.`val`) {
            list2
        } else {
            list1
        }

        head.next = mergeTwoLists(head.next, other)
        return head
    }
}
