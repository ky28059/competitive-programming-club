private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints


// Dies to time limit on test 5
fun main() {
    val (n, q) = readInts()
    // Mutable list of the n ints
    val nums = readInts().toMutableList()

    // Loop through q queries
    var i = q
    while (i > 0) {
        val line = readInts()

        when (line[0]) {
            1 -> nums.add(line[1])
            2 -> nums.filter { it != line[1] }
            3 -> println(nums.distinct().size)
            4 -> if (nums.contains(line[1])) println(1) else println(0)
        }
        i--
    }
}