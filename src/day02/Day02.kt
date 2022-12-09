package day02

import readInput

fun main() {

    fun provideInput(lines: List<String>): MutableList<MutableList<MutableList<String>>> {
        val input = mutableListOf<MutableList<MutableList<String>>>()
        var game = mutableListOf<MutableList<String>>()

        lines.forEach { line ->
            if (game.size == 3) {
                input.add(game)
                game = mutableListOf()
            }
            val round = mutableListOf<String>()
            val roundHints = line.split(" ")
            round.add(roundHints[0].lowercase()) // Another Elf act
            round.add(roundHints[1].lowercase()) // Our act
            game.add(round)
        }
        if (game.isNotEmpty()) {
            input.add(game)
        }
        return input
    }

    fun part01(lines: List<String>): Int {
        val input = provideInput(lines)
        var finalResult = 0

        input.forEach { game ->
            game.toMutableList().forEach { round ->
                when (round[1]) {
                    "x" -> {
                        round.add("1") // Act score
                        when (round[0]) { // Round score
                            "a" -> round.add("3")
                            "b" -> round.add("0")
                            "c" -> round.add("6")
                        }
                    }

                    "y" -> {
                        round.add("2")
                        when (round[0]) {
                            "a" -> round.add("6")
                            "b" -> round.add("3")
                            "c" -> round.add("0")
                        }
                    }

                    "z" -> {
                        round.add("3")
                        when (round[0]) {
                            "a" -> round.add("0")
                            "b" -> round.add("6")
                            "c" -> round.add("3")
                        }
                    }
                }
                finalResult += round[2].toInt() + round[3].toInt()
            }
        }
        return finalResult
    }

    fun part02(lines: List<String>): Int {
        val input = provideInput(lines)
        var finalResult = 0

        input.forEach { game ->
            game.toMutableList().forEach { round ->
                when (round[0]) {
                    "a" -> {
                        when (round[1]) {
                            "x" -> {
                                round.add("3") // Act score
                                round.add("0") // Round score
                            }

                            "y" -> {
                                round.add("1")
                                round.add("3")
                            }

                            "z" -> {
                                round.add("2")
                                round.add("6")
                            }
                        }
                    }

                    "b" -> {
                        when (round[1]) {
                            "x" -> {
                                round.add("1") // Act score
                                round.add("0") // Round score
                            }

                            "y" -> {
                                round.add("2")
                                round.add("3")
                            }

                            "z" -> {
                                round.add("3")
                                round.add("6")
                            }
                        }
                    }

                    "c" -> {
                        when (round[1]) {
                            "x" -> {
                                round.add("2") // Act score
                                round.add("0") // Round score
                            }

                            "y" -> {
                                round.add("3")
                                round.add("3")
                            }

                            "z" -> {
                                round.add("1")
                                round.add("6")
                            }
                        }
                    }
                }
                finalResult += round[2].toInt() + round[3].toInt()
            }
        }
        return finalResult
    }

    check(part01(readInput(targetDirectory = "day02", name = "Day02FakeData")) == 15)
    check(part02(readInput(targetDirectory = "day02", name = "Day02FakeData")) == 12)

    val finalScorePart01 = part01(readInput(targetDirectory = "day02", name = "Day02RealData"))
    val finalScorePart02 = part02(readInput(targetDirectory = "day02", name = "Day02RealData"))

    println("Final score for part01 is-> $finalScorePart01")
    println("Final score for part02 is-> $finalScorePart02")
}