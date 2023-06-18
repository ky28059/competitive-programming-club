class Solution {
    // TODO: very slow
    fun myAtoi(s: String): Int {
        val (_, sign, digits) = " *([-+]?)0*(\\d*)".toRegex().find(s)!!.groupValues

        if (digits.isEmpty()) return 0
        if ((digits.length > 10 || digits.length == 10 && digits >= "2147483648") && sign == "-") return Int.MIN_VALUE
        if ((digits.length > 10 || digits.length == 10 && digits >= "2147483647") && sign != "-") return Int.MAX_VALUE

        return "$sign$digits".toInt()
    }
}
