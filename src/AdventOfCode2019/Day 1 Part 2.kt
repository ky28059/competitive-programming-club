package AdventOfCode2019


fun main() {
    println(day1.sumBy { calculateFuel(it) })
}

// Recursively calculates the fuel required to transport a given mass.
fun calculateFuel(mass: Int): Int {
    val fuel = mass / 3 - 2
    if (fuel < 0) return 0
    return fuel + calculateFuel(fuel) // Fuel required to transport that fuel
}
