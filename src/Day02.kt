fun main() {
    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (a, b) = line.split(" ")

            when (b) {
                "X" -> {
                    score += 1
                    when (a) {
                        "A" -> {
                            score += 3
                        }
                        "C" -> {
                            score += 6
                        }
                    }
                }
                "Y" -> {
                    score += 2
                    when (a) {
                        "A" -> {
                            score += 6
                        }
                        "B" -> {
                            score += 3
                        }
                    }
                }
                "Z" -> {
                    score += 3
                    when (a) {
                        "B" -> {
                            score += 6
                        }
                        "C" -> {
                            score += 3
                        }
                    }
                }
            }
        }

        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (a, b) = line.split(" ")

            when (b) {
                "X" -> {
                    when (a) {
                        "A" -> {
                            score += 3
                        }
                        "B" -> {
                            score += 1
                        }
                        "C" -> {
                            score += 2
                        }
                    }
                }
                "Y" -> {
                    score += 3
                    when (a) {
                        "A" -> {
                            score += 1
                        }
                        "B" -> {
                            score += 2
                        }
                        "C" -> {
                            score += 3
                        }
                    }
                }
                "Z" -> {
                    score += 6
                    when (a) {
                        "A" -> {
                            score += 2
                        }
                        "B" -> {
                            score += 3
                        }
                        "C" -> {
                            score += 1
                        }
                    }
                }
            }
        }

        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
