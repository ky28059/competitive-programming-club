package AdventOfCode2020


fun main() {
    println(day4.count { checkPassport(it) })
}

// Checks whether a passport is legitimate (i.e. all fields are present and valid).
// Better way to abstract checking for existence of fields?
fun checkPassport(passport: String): Boolean {
    val fields = passport.split(" ").map { it.split(":") }

    // Birth year: between 1920-2002
    val (_, byr) = fields.find { it[0] == "byr" } ?: return false
    if (byr.toIntOrNull() !in 1920..2002) return false

    // Issue year: between 2010-2020
    val (_, iyr) = fields.find { it[0] == "iyr" } ?: return false
    if (iyr.toIntOrNull() !in 2010..2020) return false

    // Expiration year: between 2020-2030
    val (_, eyr) = fields.find { it[0] == "eyr" } ?: return false
    if (eyr.toIntOrNull() !in 2020..2030) return false

    // Height: must be within unit-dependant bounds
    val (_, hgt) = fields.find { it[0] == "hgt" } ?: return false
    val unit = hgt.takeLast(2)
    val (min, max) = when (unit) {
        "cm" -> listOf(150, 193)
        else -> listOf(59, 76) // "in"
    }
    if (hgt.dropLast(2).toIntOrNull() !in min..max) return false

    // Hair color: must be valid 6-digit hex
    val (_, hcl) = fields.find { it[0] == "hcl" } ?: return false
    if (!hcl.matches(Regex("#[a-f0-9]{6}"))) return false

    // Eye color: must be valid option
    val (_, ecl) = fields.find { it[0] == "ecl" } ?: return false
    if (ecl !in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) return false

    // Passport ID: must be 9-digit number
    val (_, pid) = fields.find { it[0] == "pid" } ?: return false
    return pid.length == 9 && pid.toIntOrNull() != null
}
