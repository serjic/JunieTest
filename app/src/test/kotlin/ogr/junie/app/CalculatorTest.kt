package ogr.junie.app

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

/**
 * Tests for the Calculator class.
 */
class CalculatorTest {
    
    private val calculator = Calculator()
    
    @Test
    fun `test add two positive numbers`() {
        assertEquals(5, calculator.add(2, 3))
    }
    
    @Test
    fun `test add positive and negative numbers`() {
        assertEquals(-1, calculator.add(2, -3))
    }
    
    @Test
    fun `test add two negative numbers`() {
        assertEquals(-5, calculator.add(-2, -3))
    }
    
    @Test
    fun `test add zero`() {
        assertEquals(3, calculator.add(3, 0))
        assertEquals(3, calculator.add(0, 3))
    }
    
    @Test
    fun `test add multiple numbers`() {
        assertEquals(10, calculator.add(1, 2, 3, 4))
    }
    
    @Test
    fun `test add empty array`() {
        assertEquals(0, calculator.add())
    }
    
    @Test
    fun `test add single number`() {
        assertEquals(5, calculator.add(5))
    }
}