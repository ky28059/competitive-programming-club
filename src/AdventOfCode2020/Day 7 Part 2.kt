package AdventOfCode2020


fun main() {
    val rules = HashMap<String, List<String>>()

    for (rule in day7) {
        val (name, contents) = rule.split(" contain ")
        val listContents = contents
            .replace(".", "")
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

            sumChildren += count.digitToInt() * recurseThroughBags(innerName)
        }

        return 1 + sumChildren
    }

    println(recurseThroughBags("shiny gold") - 1)
}
