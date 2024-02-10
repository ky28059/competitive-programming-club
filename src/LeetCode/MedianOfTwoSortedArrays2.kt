import java.util.ArrayDeque

class Solution {
    // O(m + n)
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = mergeSorted(nums1, nums2)

        val middle = (nums1.size + nums2.size - 1) / 2.0
        return (merged[ceil(middle).toInt()] + merged[floor(middle).toInt()]) / 2.0
    }

    // Merges two sorted `IntArray`s into a `List<Int>`, taking advantage of sorting for O(m + n) runtime.
    // Significantly slower than `(nums1 + nums2).sorted()`, somehow.
    fun mergeSorted(nums1: IntArray, nums2: IntArray): List<Int> {
        val firstQueue = ArrayDeque(nums1.toMutableList())
        val secondQueue = ArrayDeque(nums2.toMutableList())

        val ret = mutableListOf<Int>()
        for (i in 0 until nums1.size + nums2.size) {
            val first = firstQueue.peek() ?: return ret + secondQueue
            val second = secondQueue.peek() ?: return ret + firstQueue

            ret.add(if (first < second) {
                firstQueue.pop()
            } else {
                secondQueue.pop()
            })
        }

        return ret
    }

    // Merges two sorted `IntArray`s into an `IntArray`, taking advantage of sorting for O(m + n) runtime.
    // Even slower than using a mutable list, somehow.
    fun mergeSortedArray(nums1: IntArray, nums2: IntArray): IntArray {
        val firstQueue = ArrayDeque(nums1.toMutableList())
        val secondQueue = ArrayDeque(nums2.toMutableList())

        val ret = IntArray(nums1.size + nums2.size)
        for (i in 0 until nums1.size + nums2.size) {
            val first = firstQueue.peek() ?: return secondQueue.toIntArray().copyInto(ret, i)
            val second = secondQueue.peek() ?: return firstQueue.toIntArray().copyInto(ret, i)

            ret[i] = if (first < second) {
                firstQueue.pop()
            } else {
                secondQueue.pop()
            }
        }

        return ret
    }
}
