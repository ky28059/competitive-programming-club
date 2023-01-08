package AdventOfCode2019

import java.util.concurrent.ArrayBlockingQueue


fun main() {
    var maxOutput = 0

    for (i in 0..4) {
        for (j in (0..4).minus(i)) {
            for (k in (0..4).minus(setOf(i, j))) {
                for (l in (0..4).minus(setOf(i, j, k))) {
                    for (m in (0..4).minus(setOf(i, j, k, l))) {
                        val ampAQueue = ArrayBlockingQueue(10, true, listOf(i, 0))
                        val ampBQueue = ArrayBlockingQueue(10, true, setOf(j))
                        val ampCQueue = ArrayBlockingQueue(10, true, setOf(k))
                        val ampDQueue = ArrayBlockingQueue(10, true, setOf(l))
                        val ampEQueue = ArrayBlockingQueue(10, true, setOf(m))
                        val thrusterQueue = ArrayBlockingQueue<Int>(10)

                        val amps = listOf(
                            ThreadedIntcodeComputer(day7, ampAQueue, ampBQueue),
                            ThreadedIntcodeComputer(day7, ampBQueue, ampCQueue),
                            ThreadedIntcodeComputer(day7, ampCQueue, ampDQueue),
                            ThreadedIntcodeComputer(day7, ampDQueue, ampEQueue),
                            ThreadedIntcodeComputer(day7, ampEQueue, thrusterQueue)
                        )

                        for (amp in amps) amp.start()
                        for (amp in amps) amp.join()

                        val output = thrusterQueue.remove()
                        if (output > maxOutput) maxOutput = output
                    }
                }
            }
        }
    }

    println(maxOutput)
}
