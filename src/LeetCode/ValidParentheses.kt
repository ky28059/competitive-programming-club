class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (p in s) when (p) {
            '(', '[', '{' -> stack.addFirst(p)
            ')' -> if (stack.removeFirstOrNull() != '(') return false
            ']' -> if (stack.removeFirstOrNull() != '[') return false
            '}' -> if (stack.removeFirstOrNull() != '{') return false
        }

        return stack.isEmpty()
    }
}
