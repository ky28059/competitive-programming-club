package AdventOfCode2020


fun main() {
    var valid = 0

    for (passport in day4) {
        val fields = passport.split(" ").map { it.split(":") }

        fun isInField(query: String): Boolean {
            val search = fields.map { it[0] == query }
            return search.reduce {s1, s2 -> s1 || s2}
        }

        if (
            // Check to see if all fields are present
            isInField("ecl")
            && isInField("pid")
            && isInField("eyr")
            && isInField("hcl")
            && isInField("byr")
            && isInField("iyr")
            && isInField("hgt")
        ) valid++
    }

    println(valid)
}