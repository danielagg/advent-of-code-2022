package day6

import java.io.File

class solution {
    private val inputFilePath = "src/main/kotlin/day6/input.txt"

    fun part1(): Int { // 1929
        val line = Utils.readFile(inputFilePath)[0]
        var answer = -1
        var start = 0;

        while (answer == -1) {
            var end = start + 3
            if (line.substring(start .. end).toCharArray().distinct().count() == 4)
                answer = end + 1
            else
                start += 1
        }

        println(answer)
        return answer
    }

    fun part2(): Int {
        val line = Utils.readFile(inputFilePath)[0]
        var answer = -1
        var start = 0;

        while (answer == -1) {
            var end = start + 13
            if (line.substring(start .. end).toCharArray().distinct().count() == 14)
                answer = end + 1
            else
                start += 1
        }

        println(answer)
        return answer
    }

}