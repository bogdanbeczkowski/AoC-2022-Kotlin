import java.lang.Integer.max

fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories = 0
        var currentElf = 0
        for (line in input) {
            if (line.isNotEmpty()) {
                currentElf += line.toInt()
            } else {
                maxCalories = max(currentElf, maxCalories)
                currentElf = 0
            }
        }

        // check the last elf
        maxCalories = max(currentElf, maxCalories)

        return maxCalories
    }

    fun part2(input: List<String>): Int {
        val topThree = intArrayOf(0, 0, 0)
        var currentElf = 0
        for (line in input) {
            if (line.isNotEmpty()) {
                currentElf += line.toInt()
            } else {
                if (currentElf > topThree.min()) {
                    topThree[topThree.indexOf(topThree.min())] = currentElf
                }
                currentElf = 0
            }
        }

        // check the last elf
        if (currentElf > topThree.min()) {
            topThree[topThree.indexOf(topThree.min())] = currentElf
        }

        return topThree.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
