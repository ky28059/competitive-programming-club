package AdventOfCode2020


fun main() {
    var valid = 0

    for (passport in day4) {
        val fields = passport.split(" ").map { it.split(":") }

        if (
            // Check to see if all fields are present
            fields.any { it[0] == "ecl" }
            && fields.any { it[0] == "pid" }
            && fields.any { it[0] == "eyr" }
            && fields.any { it[0] == "hcl" }
            && fields.any { it[0] == "byr" }
            && fields.any { it[0] == "iyr" }
            && fields.any { it[0] == "hgt" }
        ) valid++
    }

    println(valid)
}