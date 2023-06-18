class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        return combinations(k, collection = (1..n).toList())
    }

    /**
     * Recursively generates all k-length combinations of a given collection starting from
     * the start index.
     *
     * @param k The length of each combination.
     * @param start The index to start at.
     * @param collection The list to generate combinations of.
     * @return The list of combinations.
     */
    private fun combinations(k: Int, start: Int = 0, collection: List<Int>): List<List<Int>> {
        // Base case for k = 0: [[]]
        // Base case for k = 1: [1, 2, 3] -> [[1], [2], [3]]
        if (k == 0) return listOf(listOf())
        if (k == 1) return collection.drop(start).map { listOf(it) }

        val retList = mutableListOf<List<Int>>()

        for (i in start..collection.size - k) {
            val nested = combinations(k - 1, i + 1, collection)
            retList.addAll(nested.map { it.plusElement(collection[i]) })
        }

        return retList
    }
}
