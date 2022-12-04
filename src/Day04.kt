fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val (first, second) = line.split(",")
            val (firstStart, firstEnd) = first.split("-")
            val (secondStart, secondEnd) = second.split("-")
            val firstRange = firstStart.toInt().rangeTo(firstEnd.toInt()).toSet()
            val secondRange = secondStart.toInt().rangeTo(secondEnd.toInt()).toSet()
            if (firstRange.containsAll(secondRange)) {
                count += 1
            } else if (secondRange.containsAll(firstRange)) {
                count += 1
            }
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val (first, second) = line.split(",")
            val (firstStart, firstEnd) = first.split("-")
            val (secondStart, secondEnd) = second.split("-")
            val firstRange = firstStart.toInt().rangeTo(firstEnd.toInt()).toSet()
            val secondRange = secondStart.toInt().rangeTo(secondEnd.toInt()).toSet()
//            if (firstRange.containsAll(secondRange)) {
//                count += firstRange.intersect(secondRange)
//            } else if (secondRange.containsAll(firstRange)) {
//                count += 1
//            }
            val intersect = firstRange.intersect(secondRange)
            if (intersect.isNotEmpty()) {
                count += 1
            }
        }

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
