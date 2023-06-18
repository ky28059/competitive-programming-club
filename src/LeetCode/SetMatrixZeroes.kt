class Solution {
    // O(n + m) space
    fun setZeroes(matrix: Array<IntArray>) {
        val rowsToSet = BooleanArray(matrix.size)
        val colsToSet = BooleanArray(matrix[0].size)

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] != 0) continue
                rowsToSet[i] = true
                colsToSet[j] = true
            }
        }

        for (i in rowsToSet.indices) if (rowsToSet[i]) {
            for (j in matrix[i].indices) matrix[i][j] = 0
        }

        for (j in colsToSet.indices) if (colsToSet[j]) {
            for (i in matrix.indices) matrix[i][j] = 0
        }
    }
}
