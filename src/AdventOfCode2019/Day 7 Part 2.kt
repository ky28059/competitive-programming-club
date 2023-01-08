package AdventOfCode2019

import java.util.concurrent.ArrayBlockingQueue


fun main() {
    var maxOutput = 0

    for (i in 5..9) {
        for (j in (5..9).minus(i)) {
            for (k in (5..9).minus(setOf(i, j))) {
                for (l in (5..9).minus(setOf(i, j, k))) {
                    for (m in (5..9).minus(setOf(i, j, k, l))) {
                        val ampAQueue = ArrayBlockingQueue(10, true, listOf(i, 0))
                        val ampBQueue = ArrayBlockingQueue(10, true, setOf(j))
                        val ampCQueue = ArrayBlockingQueue(10, true, setOf(k))
                        val ampDQueue = ArrayBlockingQueue(10, true, setOf(l))
                        val ampEQueue = ArrayBlockingQueue(10, true, setOf(m))

                        val amps = listOf(
                            ThreadedIntcodeComputer(day7, ampAQueue, ampBQueue),
                            ThreadedIntcodeComputer(day7, ampBQueue, ampCQueue),
                            ThreadedIntcodeComputer(day7, ampCQueue, ampDQueue),
                            ThreadedIntcodeComputer(day7, ampDQueue, ampEQueue),
                            ThreadedIntcodeComputer(day7, ampEQueue, ampAQueue)
                        )

                        for (amp in amps) amp.start()
                        for (amp in amps) amp.join()

                        val output = ampAQueue.remove()
                        if (output > maxOutput) maxOutput = output
                    }
                }
            }
        }
    }

    println(maxOutput)
}
