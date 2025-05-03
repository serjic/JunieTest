package ogr.junie.app

/**
 * Main entry point for the calculator application.
 * Provides a command line interface for the Calculator class.
 */
fun main(args: Array<String>) {
    val calculator = Calculator()

    if (args.isEmpty()) {
        println("Welcome to the Calculator App!")
        println("Usage: Enter numbers separated by spaces to add them together.")
        println("Enter 'exit' to quit.")

        while (true) {
            print("> ")
            val input = readLine() ?: ""

            if (input.trim().equals("exit", ignoreCase = true)) {
                println("Goodbye!")
                break
            }

            try {
                val numbers = input.split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
                    .toIntArray()

                if (numbers.isEmpty()) {
                    println("Please enter at least one number.")
                    continue
                }

                val result = calculator.add(*numbers)
                println("Result: $result")
            } catch (e: NumberFormatException) {
                println("Error: Please enter valid integers separated by spaces.")
            }
        }
    } else {
        // If arguments are provided, calculate their sum
        try {
            val numbers = args.map { it.toInt() }.toIntArray()
            val result = calculator.add(*numbers)
            println("Result: $result")
        } catch (e: NumberFormatException) {
            println("Error: Please provide valid integers as arguments.")
        }
    }
}
