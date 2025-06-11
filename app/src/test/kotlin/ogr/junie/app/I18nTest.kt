package ogr.junie.app

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Locale

class I18nTest {
    @Test
    fun testEnglishTranslations() {
        I18n.setLocale(Locale.ENGLISH)
        assertEquals("Welcome to the Calculator App!", I18n.getString("welcome"))
        assertEquals("Usage: Enter numbers separated by spaces to add them together.", I18n.getString("usage"))
        assertEquals("Enter 'exit' to quit.", I18n.getString("exit_instruction"))
        assertEquals("Goodbye!", I18n.getString("goodbye"))
        assertEquals("Please enter at least one number.", I18n.getString("enter_number"))
        assertEquals("Result: 42", I18n.getString("result", 42))
        assertEquals("Error: Please enter valid integers separated by spaces.", I18n.getString("error_invalid_input"))
        assertEquals("Error: Please provide valid integers as arguments.", I18n.getString("error_invalid_args"))
    }

    @Test
    fun testGermanTranslations() {
        I18n.setLocale(Locale.GERMAN)
        assertEquals("Willkommen bei der Taschenrechner-App!", I18n.getString("welcome"))
        assertEquals("Verwendung: Geben Sie durch Leerzeichen getrennte Zahlen ein, um sie zu addieren.", I18n.getString("usage"))
        assertEquals("Geben Sie 'exit' ein, um zu beenden.", I18n.getString("exit_instruction"))
        assertEquals("Auf Wiedersehen!", I18n.getString("goodbye"))
        assertEquals("Bitte geben Sie mindestens eine Zahl ein.", I18n.getString("enter_number"))
        assertEquals("Ergebnis: 42", I18n.getString("result", 42))
        assertEquals("Fehler: Bitte geben Sie gültige, durch Leerzeichen getrennte Ganzzahlen ein.", I18n.getString("error_invalid_input"))
        assertEquals("Fehler: Bitte geben Sie gültige Ganzzahlen als Argumente an.", I18n.getString("error_invalid_args"))
    }

    @Test
    fun testLocaleChange() {
        I18n.setLocale(Locale.ENGLISH)
        assertEquals("Welcome to the Calculator App!", I18n.getString("welcome"))
        
        I18n.setLocale(Locale.GERMAN)
        assertEquals("Willkommen bei der Taschenrechner-App!", I18n.getString("welcome"))
        
        I18n.setLocale(Locale.ENGLISH)
        assertEquals("Welcome to the Calculator App!", I18n.getString("welcome"))
    }
}