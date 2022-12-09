package day01

import readInput

fun main() {
    fun part01(lines: List<String>): Int {
        var sumOfCalories = 0
        var finalResult = 0

        lines.forEach { line ->
            if (line.isEmpty()) {
                if (sumOfCalories > finalResult) {
                    finalResult = sumOfCalories
                }
                sumOfCalories = 0
            } else {
                sumOfCalories += line.toInt()
            }
        }
        return finalResult
    }

    fun part02(lines: List<String>): Int {
        val topThreeCalories = mutableListOf<Int>()
        var sumOfCalories = 0
        lines.forEachIndexed { index, line ->
            if (line.isNotEmpty()) {
                sumOfCalories += line.toInt()
            }
            if (line.isEmpty() || index == lines.size - 1) {
                if (topThreeCalories.size < 3) {
                    topThreeCalories.add(sumOfCalories)
                } else { // Check and replace if needed
                    val clone = topThreeCalories.toMutableList()
                    val minimumNumber = clone.min()
                    if (sumOfCalories > minimumNumber) {
                        topThreeCalories.remove(minimumNumber)
                        topThreeCalories.add(sumOfCalories)
                    }
                }
                sumOfCalories = 0
            }
        }
        return topThreeCalories.sum()
    }

    check(part01(readInput(targetDirectory = "day01", name = "Day01FakeData")) == 24000)
    check(part02(readInput(targetDirectory = "day01", name = "Day01FakeData")) == 45000)

    val topCalorie = part01(readInput(targetDirectory = "day01", name = "Day01RealData"))
    val sumOfTopThreeCalories = part02(readInput(targetDirectory = "day01", name = "Day01RealData"))

    println("Top calorie is-> $topCalorie")
    println("Sum of top three calories is-> $sumOfTopThreeCalories")
}
