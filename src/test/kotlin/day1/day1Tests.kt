package day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class day1Tests {

    @Test
    fun part1() {
        val result = solution().part1()
        val expectation = 73_211
        assertEquals(result, expectation)
    }

    @Test
    fun part2() {
        val result = solution().part2()
        val expectation = 213_958
        assertEquals(result, expectation)
    }
}