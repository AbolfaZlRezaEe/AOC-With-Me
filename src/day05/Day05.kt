package day05

import readInput
import java.util.*

fun main() {
    fun part01(lines: List<String>): String {
        // Separate input and instructions
        val columns = hashMapOf<Int, LinkedList<Char>>()
        val instructions = lines.filter { line -> line.startsWith("move") }
        val input = lines.filter { line -> !line.contains("""[a-z]""".toRegex()) && line.isNotEmpty() }
        // parse the input
        input.forEach { line ->
            var columnCounter = 1
            line.forEachIndexed { index, char ->
                if (char.isLetter()
                    && line.toCharArray()[index - 1] == '['
                    && line.toCharArray()[index + 1] == ']'
                ) { // placing the blocks into lists
                    val list = if (columns.contains(index)) {
                        columns[index]!!.apply { add(char) }
                    } else {
                        LinkedList<Char>().apply { add(char) }
                    }
                    columns[index] = list
                } else if (char.isDigit()) { // placing column number into the list
                    columns[index]?.apply {
                        columns[columnCounter] = this
                        if (columnCounter != index) columns.remove(index)
                        columnCounter++
                    }
                }
            }
        }
        // Do the instructions
        instructions.forEach { instruction ->
            // index 0: amount of crates, 1: from column?, 2: to column?
            val instructionSteps =
                instruction.split(" ")
                    .filter { word -> word.contains("[0-9]".toRegex()) }
                    .map { word -> word.toInt() }
            val originColumn = columns[instructionSteps[1]]!!
            val destinationColumn = columns[instructionSteps[2]]!!
            for (amount in 1..instructionSteps[0]) {
                destinationColumn.addFirst(originColumn.pop()) // Remove first, Insert first
            }
        }

        // Get the first char of every list for creating the final message
        var finalMessage = ""
        columns.forEach { finalMessage += it.value.first }
        return finalMessage
    }

    fun part02(lines: List<String>): String {
        // Separate input and instructions
        val columns = hashMapOf<Int, LinkedList<Char>>()
        val instructions = lines.filter { line -> line.startsWith("move") }
        val input = lines.filter { line -> !line.contains("""[a-z]""".toRegex()) && line.isNotEmpty() }
        // parse the input
        input.forEach { line ->
            var columnCounter = 1
            line.forEachIndexed { index, char ->
                if (char.isLetter()
                    && line.toCharArray()[index - 1] == '['
                    && line.toCharArray()[index + 1] == ']'
                ) { // placing the blocks into lists
                    val list = if (columns.contains(index)) {
                        columns[index]!!.apply { add(char) }
                    } else {
                        LinkedList<Char>().apply { add(char) }
                    }
                    columns[index] = list
                } else if (char.isDigit()) { // placing column number into the list
                    columns[index]?.apply {
                        columns[columnCounter] = this
                        if (columnCounter != index) columns.remove(index)
                        columnCounter++
                    }
                }
            }
        }
        // Do the instructions
        instructions.forEach { instruction ->
            // index 0: amount of crates, 1: from column?, 2: to column?
            val instructionSteps =
                instruction.split(" ")
                    .filter { word -> word.contains("[0-9]".toRegex()) }
                    .map { word -> word.toInt() }
            val originColumn = columns[instructionSteps[1]]!!
            val destinationColumn = columns[instructionSteps[2]]!!
            val cratesForMoving = LinkedList<Char>()
            for (amount in 1..instructionSteps[0]) {
                cratesForMoving.addFirst(originColumn.pop())
            }
            cratesForMoving.forEach { destinationColumn.addFirst(it) }
        }

        // Get the first char of every list for creating the final message
        var finalMessage = ""
        columns.forEach { finalMessage += it.value.first }
        return finalMessage
    }

    check(part01(readInput(targetDirectory = "day05", name = "Day05FakeData")) == "CMZ")
    check(part02(readInput(targetDirectory = "day05", name = "Day05FakeData")) == "MCD")

    val part01Answer = part01(readInput(targetDirectory = "day05", name = "Day05RealData"))
    val part02Answer = part02(readInput(targetDirectory = "day05", name = "Day05RealData"))

    println("The final message in part01 is-> $part01Answer")
    println("The final message in part02 is-> $part02Answer")
}