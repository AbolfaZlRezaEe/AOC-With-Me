package day03

import readInput

fun main() {
    fun alphabetLowercaseCodeList(): HashMap<Char, Int> {
        return hashMapOf<Char, Int>().apply {
            put('a', 1)
            put('b', 2)
            put('c', 3)
            put('d', 4)
            put('e', 5)
            put('f', 6)
            put('g', 7)
            put('h', 8)
            put('i', 9)
            put('j', 10)
            put('k', 11)
            put('l', 12)
            put('m', 13)
            put('n', 14)
            put('o', 15)
            put('p', 16)
            put('q', 17)
            put('r', 18)
            put('s', 19)
            put('t', 20)
            put('u', 21)
            put('v', 22)
            put('w', 23)
            put('x', 24)
            put('y', 25)
            put('z', 26)
        }
    }

    fun alphabetUppercaseCodeList(): HashMap<Char, Int> {
        return hashMapOf<Char, Int>().apply {
            alphabetLowercaseCodeList().forEach { (char, code) ->
                put(char.uppercaseChar(), 26 + code)
            }
        }
    }

    fun part01(lines: List<String>): Int {
        val lowerCode = alphabetLowercaseCodeList()
        val upperCode = alphabetUppercaseCodeList()
        var result = 0
        lines.forEach { line ->
            val compartmentItems = line.chunked(line.length / 2)
            val firstCompartment = compartmentItems[0].toCharArray().asIterable().toSet()
            val secondCompartment = compartmentItems[1].toCharArray().asIterable().toSet()
            val sharedChar =
                firstCompartment.intersect(secondCompartment).toList()[0] // Because we only have 1 letter shared!
            result += if (sharedChar.isUpperCase()) upperCode[sharedChar]!! else lowerCode[sharedChar]!!
        }
        return result
    }

    fun part02(lines: List<String>): Int {
        val lowerCode = alphabetLowercaseCodeList()
        val upperCode = alphabetUppercaseCodeList()
        val groups = mutableListOf<MutableList<String>>()
        var group = mutableListOf<String>()
        var result = 0
        lines.forEach { line -> // Creating groups with member size of 3
            group.add(line)
            if (group.size == 3) {
                groups.add(group)
                group = mutableListOf()
            }
        }
        groups.forEach { group -> // Check shared char between three member
            val allCharacters = mutableListOf<Char>()
            val hashTable = HashMap<Char, Int>()

            allCharacters.addAll(group[0].toCharArray().toList().toSet())
            allCharacters.addAll(group[1].toCharArray().toList().toSet())
            allCharacters.addAll(group[2].toCharArray().toList().toSet())

            allCharacters.forEach { character ->
                val frequency = hashTable[character]
                if (frequency != null) {
                    hashTable[character] = frequency + 1
                } else {
                    hashTable[character] = 1
                }
            }

            val sharedChar = hashTable.filter { it.value == 3 }.keys.toList()[0]

            result += if (sharedChar.isUpperCase()) upperCode[sharedChar]!! else lowerCode[sharedChar]!!
        }
        return result
    }

    check(part01(readInput(targetDirectory = "day03", name = "Day03FakeData")) == 157)
    check(part02(readInput(targetDirectory = "day03", name = "Day03FakeData")) == 70)

    val part01Answer = part01(readInput(targetDirectory = "day03", name = "Day03RealData"))
    val part02Answer = part02(readInput(targetDirectory = "day03", name = "Day03RealData"))

    println("Sum of priorities in part01 is-> $part01Answer")
    println("Sum of priorities in part02 is-> $part02Answer")
}