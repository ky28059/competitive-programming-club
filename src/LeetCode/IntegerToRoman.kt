class Solution {
    fun intToRoman(num: Int): String {
        val ones = num % 10
        val tens = ((num % 100) - ones) / 10
        val hundreds = ((num % 1000) - tens - ones) / 100
        val thousands = (num - hundreds - tens - ones) / 1000

        return "M".repeat(thousands) + digitToRoman(hundreds, "C", "D", "M") + digitToRoman(tens, "X", "L", "C") + digitToRoman(ones, "I", "V", "X")
    }

    fun digitToRoman(num: Int, one: String, five: String, ten: String): String {
        return when (num) {
            9 -> "$one$ten"
            in 5..8 -> five + one.repeat(num - 5)
            4 -> "$one$five"
            else -> one.repeat(num)
        }
    }
}
