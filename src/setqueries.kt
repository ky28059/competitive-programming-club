private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints


fun main() {
    val (n, q) = readInts()
    // Mutable set of the n ints
    val nums = readInts().toMutableSet()

    // Loop through q queries
    var i = q
    while (i > 0) {
        val line = readInts()

        when (line[0]) {
            1 -> nums.add(line[1])
            2 -> nums.remove(line[1])
            3 -> println(nums.size)
            4 -> if (nums.contains(line[1])) println(1) else println(0)
        }
        i--
    }
}