package ogr.junie.app

/**
 * A simple calculator class that can perform basic arithmetic operations.
 */
class Calculator {
    /**
     * Adds two numbers together.
     *
     * @param a The first number
     * @param b The second number
     * @return The sum of a and b
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Adds multiple numbers together.
     *
     * @param numbers The numbers to add
     * @return The sum of all numbers
     */
    fun add(vararg numbers: Int): Int {
        return numbers.sum()
    }
}