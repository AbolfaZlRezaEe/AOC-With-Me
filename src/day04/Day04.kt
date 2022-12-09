package day04

import readInput

fun main() {

    fun part01(lines: List<String>): Int {
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
        return result
    }

    fun part02(lines: List<String>): Int {
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
        return result
    }

    check(part01(readInput(targetDirectory = "day04", name = "Day04FakeData")) == 2)
    check(part02(readInput(targetDirectory = "day04", name = "Day04FakeData")) == 4)

    val part01Answer = part01(readInput(targetDirectory = "day04", name = "Day04RealData"))
    val part02Answer = part02(readInput(targetDirectory = "day04", name = "Day04RealData"))

    println("Total number of ranges that are covered by another is-> $part01Answer")
    println("Total number of ranges that are overlapping by another is-> $part02Answer")

}