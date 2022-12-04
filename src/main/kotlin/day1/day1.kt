package day1

import java.io.File

class day1 {

    private val inputFilePath = "src/main/kotlin/day1/input.txt"

    private fun readFile(): List<String> {
        return File(inputFilePath).readLines()
    }

    private fun splitInputByElves(ungroupedData: List<String>): List<List<Int>> {
        val groups = mutableListOf<MutableList<Int>>()

        // initiate 1st entry
        groups.add(mutableListOf())

        ungroupedData
            .map {
                if(it.isNotBlank()) {
                    groups.last().add(it.toInt())
                } else {
                    groups.add(mutableListOf())
                }
            }

        return groups
    }

    fun part1() { // 73211

        val result = splitInputByElves(readFile())
            .map { it.sum() }
            .sortedDescending()
            .take(1)[0]

        println(result)
    }

    fun part2() { // 213958
        val result = splitInputByElves(readFile())
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()

        println(result)
    }
}