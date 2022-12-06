package day04

import readInput

fun main() {

    fun part01(lines: List<String>) {
        var result = 0
        lines.forEach { line ->
            val ranges = line.split(",")
            val firstRangeInRaw = ranges[0].split("-")
            val secondRangeInRaw = ranges[1].split("-")
            val firstRange = firstRangeInRaw[0].toInt()..firstRangeInRaw[1].toInt() // 2-3 converted to 2..3
            val secondRange = secondRangeInRaw[0].toInt()..secondRangeInRaw[1].toInt()
            if ((firstRange.contains(secondRange.first) && firstRange.contains(secondRange.last))
                || (secondRange.contains(firstRange.first) && secondRange.contains(firstRange.last))
            ) {
                result++
            }
        }
        println("Total number of ranges that are covered by another is-> $result")
    }

    fun part02(lines: List<String>) {
        var result = 0
        lines.forEach { line ->
            val ranges = line.split(",")
            val firstRangeInRaw = ranges[0].split("-")
            val secondRangeInRaw = ranges[1].split("-")
            val firstRange = firstRangeInRaw[0].toInt()..firstRangeInRaw[1].toInt() // 2-3 converted to 2..3
            val secondRange = secondRangeInRaw[0].toInt()..secondRangeInRaw[1].toInt()
            if ((firstRange.contains(secondRange.first) || firstRange.contains(secondRange.last))
                || (secondRange.contains(firstRange.first) || secondRange.contains(firstRange.last))
            ) {
                result++
            }
        }
        println("Total number of ranges that are overlapping by another is-> $result")
    }

    part01(readInput(targetDirectory = "day04", name = "Day04RealData"))
    part02(readInput(targetDirectory = "day04", name = "Day04RealData"))
}