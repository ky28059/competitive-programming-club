package AdventOfCode2020


fun main() {
    var valid = 0

    for (passport in day4) {
        val fields = passport.split(" ").map { it.split(":") }
        var currValid = true

        for ((field, value) in fields) {
            when (field) {
                // Only reassign validity if it is true
                // This way a later passed check will not override an already false passport
                "byr" -> if (currValid) currValid = value.toIntOrNull() in 1920..2002 // Must be within range
                "iyr" -> if (currValid) currValid = value.toIntOrNull() in 2010..2020 // Must be within range
                "eyr" -> if (currValid) currValid = value.toIntOrNull() in 2020..2030 // Must be within range
                "hgt" ->
                    if (currValid) {
                        val unit = value.substring(value.length - 2, value.length) // Unit = last 2 chars of string
                        val (min, max) = when (unit) {
                            "cm" -> listOf(150, 193)
                            else -> listOf(59, 76) // "in"
                        }
                        currValid = value.substring(0, value.length - 2).toIntOrNull() in min..max // Int given must be within range specified by unit
                    }
                "hcl" ->
                    if (currValid) currValid =
                        value[0] == '#' // First letter must be a #
                        && value.substring(1, value.length).all { it in 'a'..'f' || it.digitToIntOrNull() in 0..9 } // All characters after the # must either be a-f or 0-9
                        && value.length == 7 // Must be exactly 7 characters
                "ecl" -> if (currValid) currValid = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value) // Must be one of the specified strings
                "pid" -> if (currValid) currValid = value.toIntOrNull() != null && value.length == 9 // Must be a 9 digit valid integer
            }
        }

        // Might be nicer to do search in the checks when statement but oh well, I already wrote this code
        fun isInField(query: String): Boolean {
            val search = fields.map { it[0] == query }
            return search.reduce { s1, s2 -> s1 || s2 }
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
            && currValid // Lazily check to see if it passed all the other checks
        ) valid++
    }

    println(valid)
}