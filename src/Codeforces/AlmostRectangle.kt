private fun readInt() = readln().toInt() // single int

// Codeforces Round 713
// Question B
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val field = mutableListOf<String>()

        for (k in 0 until n) {
            field.add(readln())
        }

        val indices = field.map { it.indexOf('*') }.toMutableList()

        if (indices.count { it > -1 } == 1) {
            val index = indices.indexOfFirst { it > -1 }
            if (index >= field.size - 1) field[index - 1] = field[index]
            else field[index + 1] = field[index]
        } else {
            val first = indices.indexOfFirst { it > -1 }
            val second = indices.indexOfLast { it > -1 }

            if (indices[first] == indices[second]) {
                if (indices[first] >= field.size - 1) {
                    indices[first]--
                    indices[second]--
                } else {
                    indices[first]++
                    indices[second]++
                }
            }

            field[first] = field[first].replaceRange(indices[second], indices[second] + 1, "*")
            field[second] = field[second].replaceRange(indices[first], indices[first] + 1, "*")
        }

        println(field.joinToString("\n"))
    }
}