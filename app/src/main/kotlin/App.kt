package ogr.junie.app

import ogr.junie.utils.Messages
import java.util.Locale

/**
 * Main entry point for the calculator application.
 * Provides a command line interface for the Calculator class.
 */
fun main(args: Array<String>) {
    // Set the default locale to German for i18n support
    Locale.setDefault(Locale.GERMAN)
    
    // Get messages for the current locale
    val messages = Messages.default()
    val calculator = Calculator()

    if (args.isEmpty()) {
        println(messages.get("welcome"))
        println(messages.get("usage"))
        println(messages.get("exit_instruction"))

        while (true) {
            print(messages.get("prompt") + " ")
            val input = readLine() ?: ""

            if (input.trim().equals("exit", ignoreCase = true)) {
                println(messages.get("goodbye"))
                break
            }

            try {
                val numbers = input.split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
                    .toIntArray()

                if (numbers.isEmpty()) {
                    println(messages.get("enter_numbers"))
                    continue
                }

                val result = calculator.add(*numbers)
                println(messages.get("result", result))
            } catch (e: NumberFormatException) {
                println(messages.get("error_invalid_input"))
            }
        }
    } else {
        // If arguments are provided, calculate their sum
        try {
            val numbers = args.map { it.toInt() }.toIntArray()
            val result = calculator.add(*numbers)
            println(messages.get("result", result))
        } catch (e: NumberFormatException) {
            println(messages.get("error_invalid_args"))
        }
    }
}
