class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return strs.reduce { prefix, s -> s.commonPrefixWith(prefix) }
    }
}
