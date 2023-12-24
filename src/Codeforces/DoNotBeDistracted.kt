private fun readInt() = readln().toInt() // single int

// Codeforces Round 719
// Question A
// Accepted
fun main() {
    val t = readInt()

    for (i in 0 until t) {
        val n = readInt()
        val tasks = readln()

        if (tasks.length == 1) {
            println("YES")
            continue
        }

        var currentChar = tasks[0]
        val visited = hashSetOf(tasks[0])

        for (j in tasks.indices) {
            if (tasks[j] != currentChar && tasks[j] in visited) {
                println("NO")
                break
            }
            if (j == tasks.length - 1) {
                println("YES")
                break
            }
            currentChar = tasks[j]
            visited.add(tasks[j])
        }
    }
}