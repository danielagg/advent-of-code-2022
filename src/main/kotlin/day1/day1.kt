package day1

import java.io.File

class day1 {

    fun part1() {
        var tempSum = 0
        val groups = mutableListOf<Int>()

        File("src/main/kotlin/day1/input.txt")
            .forEachLine {
                if(it.isNotBlank()) {
                    tempSum += it.toInt()
                } else {
                    groups.add(tempSum)
                    tempSum = 0
                }
            }

        groups.sortDescending()
        println(groups[0])
    }

    fun part2() {
        var tempSum = 0
        val groups = mutableListOf<Int>()

        File("src/main/kotlin/day1/input.txt")
            .forEachLine {
                if(it.isNotBlank()) {
                    tempSum += it.toInt()
                } else {
                    groups.add(tempSum)
                    tempSum = 0
                }
            }

        groups.sortDescending()
        println(groups.take(3).sum())
    }
}