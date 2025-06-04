import kotlin.math.absoluteValue
import kotlin.math.sign

class Solution {
    fun reverse(x: Int): Int {
        var src = x.absoluteValue
        var ret = 0

        while (src > 0) {
            if (ret >= Int.MAX_VALUE / 10 + 1) return 0
            ret *= 10
            ret += src % 10
            src /= 10
        }

        return ret * x.sign
    }
}
