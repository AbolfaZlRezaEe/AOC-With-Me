import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(targetDirectory: String, name: String) = File("src/$targetDirectory", "$name.txt")
    .readLines()
