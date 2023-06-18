class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ret = mutableListOf<Int>()

        var leftBound = 0
        var rightBound = matrix[0].size - 1
        var topBound = 0
        var bottomBound = matrix.size - 1

        while (true) {
            // Go left to right
            for (i in leftBound..rightBound) ret.add(matrix[topBound][i])
            if (topBound == bottomBound) break
            topBound++

            // Go top to bottom
            for (i in topBound..bottomBound) ret.add(matrix[i][rightBound])
            if (rightBound == leftBound) break
            rightBound--

            // Go right to left
            for (i in rightBound downTo leftBound) ret.add(matrix[bottomBound][i])
            if (topBound == bottomBound) break
            bottomBound--

            // Go bottom to top
            for (i in bottomBound downTo topBound) ret.add(matrix[i][leftBound])
            if (rightBound == leftBound) break
            leftBound++
        }

        return ret.toList()
    }
}
