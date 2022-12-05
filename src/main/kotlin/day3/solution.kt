package day3


class solution {

    private val inputFilePath = "src/main/kotlin/day3/input.txt"

    fun getValueOfLetter(letter: Char): Int {
        val alphabet = charArrayOf(
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'u',
            'v',
            'w',
            'x',
            'y',
            'z'
        )

        val lowerCaseValue = alphabet.indexOf(letter.lowercaseChar()) + 1
        val upperCaseValue = lowerCaseValue + 26

        return if(letter.isLowerCase()) lowerCaseValue else upperCaseValue
    }

    fun part1(): Int {
        var result = 0

        Utils.readFile(inputFilePath)
            .map { it ->
                val middle = it.length / 2
                val leftCompartment = it.substring(0, middle).toList()
                val rightCompartment = it.substring(middle, it.length).toList()

                leftCompartment.intersect(rightCompartment).map {
                    result += getValueOfLetter(it)
                }
            }

        return result
    }

    fun part2(): Int {
        var result = 0
        val lines = Utils.readFile(inputFilePath)

        for (i in 0 until lines.count() step 3)
        {
            val group1 = lines[i].toList()
            val group2 = lines[i + 1].toList()
            val group3 = lines[i + 2].toList()

            group1.intersect(group2).intersect(group3).map{
                result += getValueOfLetter(it)
            }
        }

        return result
    }

}