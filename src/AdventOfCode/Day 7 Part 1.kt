package AdventOfCode


fun removeFinalS(plural: String): String {
    if (plural[plural.length - 1] == 's') return plural.dropLast(1)
    return plural
}

fun main() {
    val rules = HashMap<String, List<String>>()

    for (rule in day7) {
        val (name, contents) = rule.split(" contain ")
        val listContents =
                contents.replace(".", "")
                        .replace(" bag", "")
                        .split(", ")
                        .map { removeFinalS(it) }
                        .map { it.drop(2) } // Remove the number and space at the beginning

        rules[removeFinalS(name).replace(" bag", "")] = listContents
    }

    val searchFor = mutableSetOf("shiny gold")

    var matched = true

    // Loop through every entry in the hashmap until a new match cannot be found
    while(matched) {
        matched = false

        for ((name, contents) in rules) {
            if (contents.any { searchFor.contains(it) } && !searchFor.contains(name)) {
                searchFor.add(name)
                matched = true
            }
        }
    }

    println(searchFor.size - 1)
}

