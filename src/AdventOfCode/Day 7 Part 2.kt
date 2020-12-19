package AdventOfCode


fun main() {
    val rules = HashMap<String, List<String>>()

    for (rule in day7) {
        val (name, contents) = rule.split(" contain ")
        val listContents =
                contents.replace(".", "")
                        .replace(" bag", "")
                        .split(", ")
                        .map { removeFinalS(it) }

        rules[removeFinalS(name).replace(" bag", "")] = listContents
    }

    fun recurseThroughBags(name: String): Long {
        val bag = rules[name] ?: return 0 // Null safety
        if (bag[0] == "no other") return 1

        var sumChildren: Long = 0
        for (inner in bag) {
            // Extract bag count and bag name
            val count = inner[0]
            val innerName = inner.substring(2 until inner.length)

            // Cast to string first because for SOME REASON char.toInt and toLong do not try to create a number out of the contents of the char
            // '4'.toLong() is 52
            // This caused many problems.
            sumChildren += count.toString().toLong() * recurseThroughBags(innerName)
        }

        return 1 + sumChildren
    }

    println(recurseThroughBags("shiny gold") - 1)
}

