package day06

import readInput

const val MAX_BUFFER_SIZE = 4 // You should just change this value for both parts!
fun main() {
    fun answer(lines: List<String>) {
        val stringBuffer = StringBuffer()
        run {
            lines[0].forEachIndexed { index, char ->
                if (stringBuffer.length < MAX_BUFFER_SIZE) {
                    stringBuffer.append(char)
                }
                if (stringBuffer.length == MAX_BUFFER_SIZE) {
                    if (stringBuffer.toSet().size == MAX_BUFFER_SIZE) {
                        println("First marker can be found in ${index + 1} index")
                        return@run
                    }
                    stringBuffer.deleteCharAt(0)
                }
            }
        }
    }
    answer(readInput(targetDirectory = "day06", name = "Day06RealData"))
}