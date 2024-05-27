private fun readInt() = readln().toInt()

fun main() {
    val t = readInt()
    for (i in 0 until t) runTest()
}

fun runTest() {
    val isbn = readln()

    // Check checksum digit, preliminary hyphen placement
    if (!validIsbn10Checksum(isbn)) return println("invalid")
    if (isbn.first() == '-' || isbn.last() == '-') return println("invalid")

    // Check for adjacent hyphens, too many hyphens, 3 hyphens with no hyphen before checksum
    var hyphenCount = 0
    for (j in isbn.indices) {
        if (isbn[j] != '-') continue
        if (j != 0 && isbn[j - 1] == '-') return println("invalid")
        hyphenCount++
    }

    if (hyphenCount > 3) return println("invalid")
    if (isbn.length - hyphenCount != 10) return println("invalid")
    if (hyphenCount == 3 && isbn[isbn.length - 2] != '-') return println("invalid")

    // Remove checksum digit, then recalculate it with new algorithm
    val isbn13 = "978-${isbn.dropLast(1)}"
    println("$isbn13${getIsbn13Checksum(isbn13)}")
}

fun validIsbn10Checksum(isbn: String): Boolean {
    var s = isbn
        .filter { it.isDigit() }
        .mapIndexed { i, d -> (10 - i) * d.digitToInt() }
        .sum()

    // Handle "X-factor" special case
    if (isbn.last() == 'X') s += 10
    return s % 11 == 0
}

fun getIsbn13Checksum(isbn: String): Int {
    val s = isbn
        .filter { it.isDigit() }
        .mapIndexed { i, d -> d.digitToInt() * (if (i % 2 == 0) 1 else 3) }
        .sum()

    return (10 - (s % 10)) % 10
}
