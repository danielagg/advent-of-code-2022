package day5

class solution {
    private val inputFilePath = "src/main/kotlin/day5/input.txt"

    private fun performMove(crates: MutableList<MutableList<Char>>, move: Int, from: Int, to: Int): MutableList<MutableList<Char>> {
        for(i in 0 until move) {
            crates[to].add(0, crates[from].first())
            crates[from].removeFirst()
        }
        return crates
    }

    private fun performMoveV2(crates: MutableList<MutableList<Char>>, move: Int, from: Int, to: Int): MutableList<MutableList<Char>> {
        crates[to].addAll(0, crates[from].take(move))
        for(i in 0 until move) {
            crates[from].removeFirst()
        }
        return crates
    }

    private fun getCreates(lines: List<String>): MutableList<MutableList<Char>> {
        val crates = mutableListOf<MutableList<Char>>()

        for(i in 0 until lines.first().length / 4 + 1) {
            crates.add(mutableListOf())
        }

        val indexesWhereCharacterIsExpected = mutableListOf<Int>()
        for(i in 1 until lines.first().length step 4) {
            indexesWhereCharacterIsExpected.add(i)
        }

        lines
            .takeWhile { !it.startsWith(" 1") }
            .map {
                indexesWhereCharacterIsExpected.map { innerIt ->
                    it[innerIt]
                }.mapIndexed { colIndex, value ->
                    if(value != ' ') {
                        crates[colIndex].add(value)
                    }
                }
            }

        return crates
    }

    fun part1() { // TGWSMRBPN
        val lines = Utils.readFile(inputFilePath)
        var crates = getCreates(lines)

        lines
            .dropWhile { !it.startsWith("move") }
            .map {
                val move = it.split("from")[0].replace("move ", "").trim().toInt()
                val from = it.split("from")[1].split("to")[0].trim().toInt()
                val to = it.split("from")[1].split("to")[1].trim().toInt()

                crates = performMove(crates, move, from - 1, to - 1)
            }

        println(crates.filter { it.any() }.map { it.first() }.joinToString(""))
    }

    fun part2() { // TZLTLWRNF
        val lines = Utils.readFile(inputFilePath)
        var crates = getCreates(lines)

        lines
            .dropWhile { !it.startsWith("move") }
            .map {
                val move = it.split("from")[0].replace("move ", "").trim().toInt()
                val from = it.split("from")[1].split("to")[0].trim().toInt()
                val to = it.split("from")[1].split("to")[1].trim().toInt()

                crates = performMoveV2(crates, move, from - 1, to - 1)
            }

        println(crates.filter { it.any() }.map { it.first() }.joinToString(""))
    }
}