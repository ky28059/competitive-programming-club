import kotlin.math.max

class Solution {
    fun addBinary(a: String, b: String): String {
        var ret = ""
        var carry = false

        for (d in 0 until max(a.length, b.length)) {
            val ai = a.length - 1 - d
            val bi = b.length - 1 - d

            val numA = if (ai < 0) 0 else a[ai].digitToInt()
            val numB = if (bi < 0) 0 else b[bi].digitToInt()
            val sum = numA + numB + if (carry) 1 else 0

            ret = (sum % 2).toString() + ret
            carry = sum >= 2
        }

        if (carry) ret = "1$ret"
        return ret
    }
}
