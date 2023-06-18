import kotlin.math.absoluteValue
import kotlin.math.sign

class Solution {
    fun reverse(x: Int): Int {
        return try {
            x.absoluteValue.toString().reversed().toInt() * x.sign
        } catch (e: Exception) {
            0
        }
    }
}
