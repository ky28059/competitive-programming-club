package AdventOfCode2020


fun main() {
    val requiredFields = setOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")
    println(day4.count { it.split(" ").map { f -> f.split(":")[0] }.containsAll(requiredFields) })
}
