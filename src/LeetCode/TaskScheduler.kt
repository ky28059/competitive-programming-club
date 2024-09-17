class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counts = tasks.groupBy { it }

        val max = counts.maxOf { it.value.size }
        val maxCount = counts.count { it.value.size == max }

        return tasks.size.coerceAtLeast((max - 1) * (n + 1) + maxCount)
    }
}
