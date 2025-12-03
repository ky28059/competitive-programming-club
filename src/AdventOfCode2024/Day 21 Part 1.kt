package AdventOfCode2024


val numpad = listOf(
    '7', '8', '9',
    '4', '5', '6',
    '1', '2', '3',
    ' ', '0', 'A'
)
val dirpad = listOf(
    ' ', '^', 'A',
    '<', 'v', '>'
)

fun main() {
    val vertices = mutableSetOf<Triple<Int, Int, Int>>()
    for (i in numpad.indices) {
        if (numpad[i] == ' ') continue
        for (j in dirpad.indices) {
            if (dirpad[j] == ' ') continue
            for (k in dirpad.indices) {
                if (dirpad[k] == ' ') continue
                vertices.add(Triple(i, j, k))
            }
        }
    }

    val dist = mutableMapOf<Triple<Int, Int, Int>, MutableMap<Triple<Int, Int, Int>, Int>>()
    for (u in vertices) {
        dist[u] = mutableMapOf()

        for (v in vertices) {
            if (u == v) dist[u]!![v] = 0

            val (u1, u2, u3) = u
            val (v1, v2, v3) = v

            if (
                (isLeft(u3, v3) && u2 == v2 && u1 == v1)
                || (isRight(u3, v3) && u2 == v2 && u1 == v1)
                || (isUp(u3, v3) && u2 == v2 && u1 == v1)
                || (isDown(u3, v3) && u2 == v2 && u1 == v1)
                || (dirpad[u3] == '^' && u3 == v3 && isUp(u2, v2) && u1 == v1)
                || (dirpad[u3] == 'v' && u3 == v3 && isDown(u2, v2) && u1 == v1)
                || (dirpad[u3] == '<' && u3 == v3 && isLeft(u2, v2) && u1 == v1)
                || (dirpad[u3] == '>' && u3 == v3 && isRight(u2, v2) && u1 == v1)
                || (dirpad[u3] == 'A' && u3 == v3 && dirpad[u2] == '^' && u2 == v2 && isUp(u1, v1))
                || (dirpad[u3] == 'A' && u3 == v3 && dirpad[u2] == 'v' && u2 == v2 && isDown(u1, v1))
                || (dirpad[u3] == 'A' && u3 == v3 && dirpad[u2] == '<' && u2 == v2 && isLeft(u1, v1))
                || (dirpad[u3] == 'A' && u3 == v3 && dirpad[u2] == '>' && u2 == v2 && isRight(u1, v1))
            ) {
                dist[u]!![v] = 1
            } else {
                dist[u]!![v] = Int.MAX_VALUE
            }
        }
    }

    // Floyd Warshall
    for (k in vertices) {
        for (i in vertices) {
            for (j in vertices) {
                if (dist[i]!![k]!! == Int.MAX_VALUE || dist[k]!![j]!! == Int.MAX_VALUE) continue
                if (dist[i]!![j]!! > dist[i]!![k]!! + dist[k]!![j]!!)
                    dist[i]!![j] = dist[i]!![k]!! + dist[k]!![j]!!
            }
        }
    }

    val dirA = dirpad.indexOf('A')
    val start = Triple(numpad.indexOf('A'), dirA, dirA)

    println(day21.sumOf {
        val states = it.map { c -> Triple(numpad.indexOf(c), dirA, dirA) }

        var curr = start
        var sum = 0

        for (i in states) {
            sum += dist[curr]!![i]!! + 1  // For pressing 'A' to input the character
            curr = i
        }
        // println("$it $sum")
        sum * it.dropLast(1).toInt()
    })
}

fun isLeft(u: Int, v: Int): Boolean {
    return u % 3 != 0 && u - 1 == v
}

fun isRight(u: Int, v: Int): Boolean {
    return u % 3 != 2 && u + 1 == v
}

fun isUp(u: Int, v: Int): Boolean {
    return u - 3 == v
}

fun isDown(u: Int, v: Int): Boolean {
    return u + 3 == v
}
