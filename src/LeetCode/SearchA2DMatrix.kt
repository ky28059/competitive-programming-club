class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size - 1
        var m = 0

        // Binary search outside
        while (l <= r) {
            m = (l + r) / 2
            if (matrix[m].last() < target) l = m + 1
            else if (matrix[m][0] > target) r = m - 1
            else break
        }

        // Binary search inside
        return matrix[m].binarySearch(target) >= 0
    }
}
