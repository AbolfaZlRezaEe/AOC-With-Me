package day06

import readInput

const val DAY01_MAX_BUFFER_SIZE = 4
const val DAY02_MAX_BUFFER_SIZE = 14
fun main() {
    fun answer(lines: List<String>, bufferSize: Int): Int {
        val stringBuffer = StringBuffer()
        lines[0].forEachIndexed { index, char ->
            if (stringBuffer.length < bufferSize) {
                stringBuffer.append(char)
            }
            if (stringBuffer.length == bufferSize) {
                if (stringBuffer.toSet().size == bufferSize) {
                    return index + 1
                }
                stringBuffer.deleteCharAt(0)
            }
        }
        return -1
    }

    check(answer(readInput(targetDirectory = "day06", name = "Day06FakeData"), DAY01_MAX_BUFFER_SIZE) == 7)
    check(answer(readInput(targetDirectory = "day06", name = "Day06FakeData"), DAY02_MAX_BUFFER_SIZE) == 19)

    val part01Answer = answer(readInput(targetDirectory = "day06", name = "Day06RealData"), DAY01_MAX_BUFFER_SIZE)
    val part02Answer = answer(readInput(targetDirectory = "day06", name = "Day06RealData"), DAY02_MAX_BUFFER_SIZE)

    println("First marker can be found for part01 in $part01Answer index")
    println("First marker can be found for part02 in $part02Answer index")
}