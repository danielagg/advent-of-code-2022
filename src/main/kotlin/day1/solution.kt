package day1

import Utils

class solution {

    private val inputFilePath = "src/main/kotlin/day1/input.txt"

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

    fun part1(): Int {
        return splitInputByElves(Utils.readFile(inputFilePath))
            .map { it.sum() }
            .maxOf { it }
    }

    fun part2(): Int {
        return splitInputByElves(Utils.readFile(inputFilePath))
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }
}