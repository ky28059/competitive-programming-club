class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false

        var curr = n
        while (curr > 1) {
            if (curr % 3 != 0) return false
            curr /= 3
        }
        return true
    }
}
