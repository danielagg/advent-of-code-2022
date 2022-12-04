package day2

class solution {

    // The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.

    // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
    private val inputFilePath = "src/main/kotlin/day2/input.txt"

    private fun getValueByPlayedEntry(entry: Char): Int {
        return when (entry) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> 0 // impossible
        }
    }

    private fun getValueByWinOrLoss_Part1(mine: Char, opponent: Char): Int {
        val gameOutcome = mapOf(
            "XA" to 3, "XB" to 0, "XC" to 6,
            "YA" to 6, "YB" to 3, "YC" to 0,
            "ZA" to 0, "ZB" to 6, "ZC" to 3,
        )

        return gameOutcome["$mine$opponent"]!!
    }

    // The second column is what I play, X for Rock, Y for Paper, and Z for Scissors.
    fun part1() { // 13268
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val opponent = it[0]
                val mine = it[2]

                result += getValueByPlayedEntry(mine)
                result += getValueByWinOrLoss_Part1(mine, opponent)
            }

        println(result)
    }

    private fun getValueByWinOrLoss_Part2(opponent: Char, expectedGameStatus: Char): Int {
        // eg. AX means, opponent plays rock, and we need to lose --> we play scissors --> scissor gives us 3 points
        // 1 for Rock, 2 for Paper, and 3 for Scissors
        // A for Rock, B for Paper, and C for Scissors.
        // X for lose, Y for draw, and Z for win.
        val gameOutcome = mapOf(
            "AX" to 3, "AY" to 1, "AZ" to 2,
            "BX" to 1, "BY" to 2, "BZ" to 3,
            "CX" to 2, "CY" to 3, "CZ" to 1,
        )

        return gameOutcome["$opponent$expectedGameStatus"]!!
    }

    // The second column is what I need to do: X for lose, Y for draw, and Z for win.
    fun part2() {
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val opponent = it[0]
                val expectedGameStatus = it[2]

                when (expectedGameStatus) {
                    'X' -> result += 0
                    'Y' -> result += 3
                    'Z' -> result += 6
                }
                result += getValueByWinOrLoss_Part2(opponent, expectedGameStatus)
            }

        println(result)
    }
}