package ogr.junie.utils

import kotlin.test.Test
import kotlin.test.assertEquals
import java.util.Locale

/**
 * Tests for the Messages class.
 */
class MessagesTest {

    @Test
    fun testEnglishMessages() {
        val messages = Messages.forLocale(Locale.ENGLISH)
        
        // Test welcome messages
        assertEquals("Welcome to the Calculator App!", messages.get("welcome"))
        assertEquals("Usage: Enter numbers separated by spaces to add them together.", messages.get("usage"))
        assertEquals("Enter 'exit' to quit.", messages.get("exit_instruction"))
        
        // Test user interaction messages
        assertEquals(">", messages.get("prompt"))
        assertEquals("Goodbye!", messages.get("goodbye"))
        assertEquals("Please enter at least one number.", messages.get("enter_numbers"))
        
        // Test result message with parameter
        assertEquals("Result: 42", messages.get("result", 42))
        
        // Test error messages
        assertEquals("Error: Please enter valid integers separated by spaces.", messages.get("error_invalid_input"))
        assertEquals("Error: Please provide valid integers as arguments.", messages.get("error_invalid_args"))
    }
    
    @Test
    fun testGermanMessages() {
        val messages = Messages.forLocale(Locale.GERMAN)
        
        // Test welcome messages
        assertEquals("Willkommen bei der Taschenrechner-App!", messages.get("welcome"))
        assertEquals("Verwendung: Geben Sie durch Leerzeichen getrennte Zahlen ein, um sie zu addieren.", messages.get("usage"))
        assertEquals("Geben Sie 'exit' ein, um zu beenden.", messages.get("exit_instruction"))
        
        // Test user interaction messages
        assertEquals(">", messages.get("prompt"))
        assertEquals("Auf Wiedersehen!", messages.get("goodbye"))
        assertEquals("Bitte geben Sie mindestens eine Zahl ein.", messages.get("enter_numbers"))
        
        // Test result message with parameter
        assertEquals("Ergebnis: 42", messages.get("result", 42))
        
        // Test error messages
        assertEquals("Fehler: Bitte geben Sie gültige, durch Leerzeichen getrennte Ganzzahlen ein.", messages.get("error_invalid_input"))
        assertEquals("Fehler: Bitte geben Sie gültige Ganzzahlen als Argumente an.", messages.get("error_invalid_args"))
    }
    
    @Test
    fun testDefaultLocale() {
        // Save the original default locale
        val originalLocale = Locale.getDefault()
        
        try {
            // Set the default locale to German
            Locale.setDefault(Locale.GERMAN)
            val messages = Messages.default()
            
            // Verify that we get German messages
            assertEquals("Willkommen bei der Taschenrechner-App!", messages.get("welcome"))
            
            // Set the default locale to English
            Locale.setDefault(Locale.ENGLISH)
            val englishMessages = Messages.default()
            
            // Verify that we get English messages
            assertEquals("Welcome to the Calculator App!", englishMessages.get("welcome"))
        } finally {
            // Restore the original default locale
            Locale.setDefault(originalLocale)
        }
    }
}