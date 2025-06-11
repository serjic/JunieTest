package ogr.junie.app

import ogr.junie.utils.I18n

/**
 * Main entry point for the calculator application.
 * Provides a command line interface for the Calculator class.
 */
fun main(args: Array<String>) {
    val calculator = Calculator()
    
    // Process language argument if present
    var processedArgs = args
    if (args.isNotEmpty() && args[0] == "--lang" && args.size > 1) {
        val lang = args[1]
        I18n.init(lang)
        processedArgs = args.drop(2).toTypedArray()
    } else {
        // Default to system language
        I18n.init(System.getProperty("user.language", "en"))
    }

    if (processedArgs.isEmpty()) {
        println(I18n.get("welcome"))
        println(I18n.get("usage"))
        println(I18n.get("exit_instruction"))

        while (true) {
            print("> ")
            val input = readLine() ?: ""

            if (input.trim().equals("exit", ignoreCase = true)) {
                println(I18n.get("goodbye"))
                break
            }

            try {
                val numbers = input.split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
                    .toIntArray()

                if (numbers.isEmpty()) {
                    println(I18n.get("enter_number"))
                    continue
                }

                val result = calculator.add(*numbers)
                println(I18n.format("result", result))
            } catch (e: NumberFormatException) {
                println(I18n.get("error_invalid_input"))
            }
        }
    } else {
        // If arguments are provided, calculate their sum
        try {
            val numbers = processedArgs.map { it.toInt() }.toIntArray()
            val result = calculator.add(*numbers)
            println(I18n.format("result", result))
        } catch (e: NumberFormatException) {
            println(I18n.get("error_invalid_args"))
        }
    }
}
