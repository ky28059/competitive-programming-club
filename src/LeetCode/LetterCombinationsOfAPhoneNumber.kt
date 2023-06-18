class Solution {
    fun letterCombinations(digits: String): List<String> {
        return when (digits) {
            "" -> listOf()
            "2" -> listOf("a", "b", "c")
            "3" -> listOf("d", "e", "f")
            "4" -> listOf("g", "h", "i")
            "5" -> listOf("j", "k", "l")
            "6" -> listOf("m", "n", "o")
            "7" -> listOf("p", "q", "r", "s")
            "8" -> listOf("t", "u", "v")
            "9" -> listOf("w", "x", "y", "z")
            else -> {
                val letters = letterCombinations(digits.take(1))
                val rest = letterCombinations(digits.drop(1))

                return letters.flatMap { s -> rest.map { s + it } }
            }
        }
    }
}
