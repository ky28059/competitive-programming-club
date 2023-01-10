package AdventOfCode2019


fun main() {
    val orbits = mutableMapOf<String, MutableList<String>>()

    // Populate orbits map with each planet and a list of all direct orbiters
    for ((planet, orbiter) in day6) {
        if (orbits[planet] == null) orbits[planet] = mutableListOf()
        orbits[planet]!!.add(orbiter)
    }

    // Sum orbits starting at the "COM" root
    println(sumOrbits(orbits, "COM"))
}

// Recursively sum orbits given a map between planets and their orbiter children. For any given planet, each child
// will add 1 direct orbit and `level - 1` indirect orbits to the sum.
fun sumOrbits(orbits: Map<String, MutableList<String>>, planet: String, level: Int = 1): Int {
    val orbiters = orbits[planet]
    if (orbiters.isNullOrEmpty()) return 0
    return orbiters.size * level + orbiters.sumOf { sumOrbits(orbits, it, level + 1) }
}
