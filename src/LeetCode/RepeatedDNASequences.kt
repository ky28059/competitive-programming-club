class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        var curr = s.substring(0, 10)
        val seen = mutableSetOf(curr)
        val ret = mutableSetOf<String>()

        for (i in 10 until s.length) {
            curr = curr.drop(1) + s[i]
            if (!seen.add(curr)) ret.add(curr)
        }

        return ret.toList()
    }
}
