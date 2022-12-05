package day2

class solution {

    private val inputFilePath = "src/main/kotlin/day2/input.txt"

    private fun getValueOfPlayedEntry(entry: Char): Int {
        // X for Rock and is worth 1, Y for Paper and is worth 2, and Z for Scissors and is worth 3
        return when (entry) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> 0 // impossible
        }
    }

    private fun getValueOfGameOutComeByPlayedEntries(myEntry: Char, opponentEntry: Char): Int {
        // map of all game outcomes, with their corresponding score
        val gameOutcome = mapOf(
            "XA" to 3, "XB" to 0, "XC" to 6,
            "YA" to 6, "YB" to 3, "YC" to 0,
            "ZA" to 0, "ZB" to 6, "ZC" to 3,
        )

        return gameOutcome["$myEntry$opponentEntry"]!!
    }

    private fun getValueOfGameOutComeByExpectedOutcome(expectedOutcome: Char): Int {
        return when (expectedOutcome) {
            'X' -> 0 // loss
            'Y' -> 3 // draw
            'Z' -> 6 // win
            else -> -1 // impossible
        }
    }

    private fun getScoreOfPlayedEntry(expectedOutcome: Char, opponentEntry: Char): Int {
        // AX --> opponent plays A (rock), we expect a loss (X), therefore we need to play scissors, which is worth 3 points
        // AY --> opponent plays A (rock), we expect a draw (Y), therefore we need to play rock, which is worth 1 point
        val gameOutcome = mapOf(
            "AX" to 3, "AY" to 1, "AZ" to 2,
            "BX" to 1, "BY" to 2, "BZ" to 3,
            "CX" to 2, "CY" to 3, "CZ" to 1,
        )

        return gameOutcome["$opponentEntry$expectedOutcome"]!!
    }

    fun part1(): Int {
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val playedEntryByOpponent = it[0]
                val playedEntryByMyself = it[2]

                result += getValueOfPlayedEntry(playedEntryByMyself)
                result += getValueOfGameOutComeByPlayedEntries(playedEntryByMyself, playedEntryByOpponent)
            }

        return result
    }


    fun part2(): Int {
        var result = 0

        Utils.readFile(inputFilePath)
            .map {
                val playedEntryByOpponent = it[0]
                val expectedGameOutcome = it[2]

                result += getValueOfGameOutComeByExpectedOutcome(expectedGameOutcome)
                result += getScoreOfPlayedEntry(expectedGameOutcome, playedEntryByOpponent)
            }

        return result
    }
}