import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class Tests {
    @Test fun day_1_part1() { assertEquals(73_211, day1.solution().part1()) }
    @Test fun day_1_part2() { assertEquals(213_958, day1.solution().part2()) }

    @Test fun day_2_part1() { assertEquals(13_268, day2.solution().part1()) }
    @Test fun day_2_part2() { assertEquals(15_508, day2.solution().part2()) }

    @Test fun day_3_part1() { assertEquals(7_850, day3.solution().part1()) }
    @Test fun day_3_part2() { assertEquals(2_581, day3.solution().part2()) }

    @Test fun day_4_part1() { assertEquals(453, day4.solution().part1()) }
    @Test fun day_4_part2() { assertEquals(919, day4.solution().part2()) }

    @Test fun day_5_part1() { assertEquals("TGWSMRBPN", day5.solution().part1()) }
    @Test fun day_5_part2() { assertEquals("TZLTLWRNF", day5.solution().part2()) }
}