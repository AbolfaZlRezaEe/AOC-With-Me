package day01

import readInput

fun main() {
    fun part01(lines: List<String>) {
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
        println("Higher calories is-> $finalResult")
    }

    fun part02(lines: List<String>) {
        val topThreeCalories = mutableListOf<Int>()
        var sumOfCalories = 0
        lines.forEach { line ->
            if (line.isEmpty()) {
                if (topThreeCalories.size < 3) {
                    topThreeCalories.add(sumOfCalories)
                } else { // Check and replace if needed
                    val clone = topThreeCalories.toMutableList()
                    run checkTopThree@{
                        clone.forEach {
                            if (sumOfCalories > it) {
                                topThreeCalories.remove(it)
                                topThreeCalories.add(sumOfCalories)
                                return@checkTopThree
                            }
                        }
                    }
                }
                sumOfCalories = 0
            } else {
                sumOfCalories += line.toInt()
            }
        }
        println("Sum of top three calories is-> ${topThreeCalories.sum()}")
    }

    part01(readInput(targetDirectory = "day01", name = "Day01FakeData"))
    part02(readInput(targetDirectory = "day01", name = "Day01RealData"))
}
