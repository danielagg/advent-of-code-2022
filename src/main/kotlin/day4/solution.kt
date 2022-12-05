package day4

class solution {
    private val inputFilePath = "src/main/kotlin/day4/input.txt"

    private fun isCompletelyOverlapping(x: String, y: String): Boolean {
        val okByStart = x.split('-')[0].toInt() <= y.split('-')[0].toInt()
        val okByEnd = x.split('-')[1].toInt() >= y.split('-')[1].toInt()

        return okByStart && okByEnd
    }

    private fun isOverlappingAtAll(x: String, y: String): Boolean {
        // x start is less than y start, but x end is more than y start
        val xStart = x.split('-')[0].toInt()
        val xEnd = x.split('-')[1].toInt()
        val yStart = y.split('-')[0].toInt()

        return xStart <= yStart && xEnd >= yStart
    }

    fun part1(): Int {
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val elf1 = it.split(',')[0]
                val elf2 = it.split(',')[1]

                val isElf1CoveringElf2 = isCompletelyOverlapping(elf1, elf2)
                val isElf2CoveringElf1 = isCompletelyOverlapping(elf2, elf1)

                if(isElf1CoveringElf2 || isElf2CoveringElf1) {
                    result++
                }
            }

        return result
    }

    fun part2(): Int {
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val elf1 = it.split(',')[0]
                val elf2 = it.split(',')[1]

                val isElf1OverlappingElf2 = isOverlappingAtAll(elf1, elf2)
                val isElf2OverlappingElf1 = isOverlappingAtAll(elf2, elf1)

                if(isElf1OverlappingElf2 || isElf2OverlappingElf1) {
                    result++
                }
            }

        return result
    }
}