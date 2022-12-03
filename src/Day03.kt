fun main() {
    fun part1(input: List<String>): Int {
        var priority = 0
        for (line in input) {
            val compartmentLength = line.length / 2
            val compartments = line.chunked(compartmentLength)
            val first = compartments.first().toCharArray()
            val second = compartments.last().toCharArray()
            val commonElement = first.intersect(second.asIterable()).first()
            var elementPriority: Int
            if (commonElement in 'a'.rangeTo('z')) {
                elementPriority = commonElement.code - 'a'.code + 1
            } else {
                elementPriority = commonElement.code - 'A'.code + 27
            }
            priority += elementPriority
        }
        return priority
    }

    fun part2(input: List<String>): Int {
        var priority = 0
        for (group in input.chunked(3)) {
            val sets = group.map { it.toCharArray().asIterable() }
            val commonElement = sets[0].intersect(sets[1]).intersect(sets[2]).first()
            var elementPriority: Int
            if (commonElement in 'a'.rangeTo('z')) {
                elementPriority = commonElement.code - 'a'.code + 1
            } else {
                elementPriority = commonElement.code - 'A'.code + 27
            }
            priority += elementPriority
        }
        return priority
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
