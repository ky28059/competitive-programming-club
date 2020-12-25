package AdventOfCode2020


fun main() {
    val (timestamp, buses) = day13
    val t = timestamp.toInt()

    var minWait = t
    var minBusID = 0

    for (busID in buses.split(',')) {
        val id = busID.toIntOrNull()

        if (id != null) {
            // t % id is the time of the last bus before the timestamp, so subtract it from id
            // to get the time of the next bus after the timestamp
            val min = id - t % id
            if (min < minWait) {
                minWait = min
                minBusID = id
            }
        }
    }

    println(minBusID * minWait)
}