package AdventOfCode2022

import kotlin.math.min


fun main() {
    // Total disk size 70000000, available disk size 70000000 - root dir size, need 30000000 for update
    println(minDeletableDir(day7FileSystem.root, 30000000 - (70000000 - day7FileSystem.root.getDiskSize())))
}

// Recursively finds the minimum directory size above the given minimum.
fun minDeletableDir(dir: FileSystem.Node, minSize: Int): Int {
    if (dir.children.isEmpty()) return Int.MAX_VALUE // Better way of excluding files?

    val size = dir.getDiskSize()
    return if (size >= minSize) min(dir.children.minOf { minDeletableDir(it, minSize) }, size)
    else dir.children.minOf { minDeletableDir(it, minSize) }
}
