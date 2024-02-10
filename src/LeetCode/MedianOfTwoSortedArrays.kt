class Solution {
    // O((m + n)log(m + n))
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = (nums1 + nums2).sorted()

        val middle = (nums1.size + nums2.size - 1) / 2.0
        return (merged[ceil(middle).toInt()] + merged[floor(middle).toInt()]) / 2.0
    }
}
