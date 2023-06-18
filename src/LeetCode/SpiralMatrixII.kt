class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }

        var leftBound = 0
        var rightBound = n - 1
        var topBound = 0
        var bottomBound = n - 1

        var counter = 1

        while (true) {
            // Go left to right
            for (i in leftBound..rightBound) matrix[topBound][i] = counter++
            if (topBound == bottomBound) break
            topBound++

            // Go top to bottom
            for (i in topBound..bottomBound) matrix[i][rightBound] = counter++
            if (rightBound == leftBound) break
            rightBound--

            // Go right to left
            for (i in rightBound downTo leftBound) matrix[bottomBound][i] = counter++
            if (topBound == bottomBound) break
            bottomBound--

            // Go bottom to top
            for (i in bottomBound downTo topBound) matrix[i][leftBound] = counter++
            if (rightBound == leftBound) break
            leftBound++
        }

        return matrix
    }
}
