package AdventOfCode2022


val day7FileSystem = createFileSystem()

fun main() {
    println(sumSmallDirs(day7FileSystem.root))
}

// Recursively sums all directories with total size <= 100000
fun sumSmallDirs(dir: FileSystem.Node): Int {
    if (dir.children.isEmpty()) return 0 // Better way of excluding files?

    val size = dir.getDiskSize()
    return if (size <= 100000) dir.children.sumBy { sumSmallDirs(it) } + size
    else dir.children.sumBy { sumSmallDirs(it) }
}

// Creates and populates a `FileSystem` based on the given instructions.
fun createFileSystem(): FileSystem {
    val fileSystem = FileSystem()
    var workingDirectory = fileSystem.root

    for (instr in day7.drop(1)) {
        val cmdStr = instr[0]

        if (cmdStr == "ls") {
            // Add all revealed files to the file system
            for (l in instr.drop(1)) {
                val (type, name) = l.split(" ")
                if (type == "dir") workingDirectory.children.add(FileSystem.Directory(name, workingDirectory))
                else workingDirectory.children.add(FileSystem.File(name, workingDirectory, type.toInt()))
            }
        } else {
            // Change working directory to given argument
            val (_, dir) = cmdStr.split(" ")
            workingDirectory = when (dir) {
                "/" -> fileSystem.root
                ".." -> workingDirectory.parent!!
                else -> (workingDirectory.children.find { it.name == dir } as FileSystem.Directory)
            }
        }
    }

    return fileSystem
}

// A tree-like structure to represent the day 7 device filesystem.
class FileSystem {
    val root = Directory("/", null)

    abstract class Node(val name: String, val parent: Directory?) {
        val children: MutableList<Node> = mutableListOf()
        abstract fun getDiskSize(): Int
    }

    class Directory(name: String, parent: Directory?) : Node(name, parent) {
        override fun getDiskSize(): Int {
            return children.sumBy { it.getDiskSize() }
        }
    }

    class File(name: String, parent: Directory, val size: Int): Node(name, parent) {
        override fun getDiskSize(): Int {
            return size
        }
    }
}
