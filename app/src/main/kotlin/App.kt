package ogr.junie.app

import java.util.Locale

/**
 * Main entry point for the calculator application.
 * Provides a command line interface for the Calculator class.
 */
fun main(args: Array<String>) {
    val calculator = Calculator()

    // Check for language option
    var processedArgs = args
    if (args.isNotEmpty() && args[0] == "--lang") {
        if (args.size > 1) {
            val lang = args[1]
            when (lang.lowercase()) {
                "de", "german" -> I18n.setLocale(Locale.GERMAN)
                "en", "english" -> I18n.setLocale(Locale.ENGLISH)
                else -> println("Unsupported language: $lang. Using default.")
            }
            processedArgs = if (args.size > 2) args.sliceArray(2 until args.size) else emptyArray()
        } else {
            println("Language option requires a parameter. Using default.")
            processedArgs = emptyArray()
        }
    }

    if (processedArgs.isEmpty()) {
        println(I18n.getString("welcome"))
        println(I18n.getString("usage"))
        println(I18n.getString("exit_instruction"))

        while (true) {
            print("> ")
            val input = readLine() ?: ""

            if (input.trim().equals("exit", ignoreCase = true)) {
                println(I18n.getString("goodbye"))
                break
            }

            try {
                val numbers = input.split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
                    .toIntArray()

                if (numbers.isEmpty()) {
                    println(I18n.getString("enter_number"))
                    continue
                }

                val result = calculator.add(*numbers)
                println(I18n.getString("result", result))
            } catch (e: NumberFormatException) {
                println(I18n.getString("error_invalid_input"))
            }
        }
    } else {
        // If arguments are provided, calculate their sum
        try {
            val numbers = processedArgs.map { it.toInt() }.toIntArray()
            val result = calculator.add(*numbers)
            println(I18n.getString("result", result))
        } catch (e: NumberFormatException) {
            println(I18n.getString("error_invalid_args"))
        }
    }
}
