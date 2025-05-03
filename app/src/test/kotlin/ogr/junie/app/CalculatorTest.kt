package ogr.junie.app

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Tests for the Calculator class.
 */
class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun testAddTwoPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3))
    }

    @Test
    fun testAddPositiveAndNegativeNumbers() {
        assertEquals(-1, calculator.add(2, -3))
    }

    @Test
    fun testAddTwoNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3))
    }

    @Test
    fun testAddZero() {
        assertEquals(3, calculator.add(3, 0))
        assertEquals(3, calculator.add(0, 3))
    }

    @Test
    fun testAddMultipleNumbers() {
        assertEquals(10, calculator.add(1, 2, 3, 4))
    }

    @Test
    fun testAddEmptyArray() {
        assertEquals(0, calculator.add())
    }

    @Test
    fun testAddSingleNumber() {
        assertEquals(5, calculator.add(5))
    }
}
