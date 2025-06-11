package ogr.junie.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class I18nTest {
    @Test
    fun testEnglishLocalization() {
        // Initialize with English locale
        I18n.init("en")
        
        // Test some strings
        assertEquals("Welcome to the Calculator App!", I18n.get("welcome"))
        assertEquals("Usage: Enter numbers separated by spaces to add them together.", I18n.get("usage"))
        assertEquals("Enter 'exit' to quit.", I18n.get("exit_instruction"))
        assertEquals("Result: 42", I18n.format("result", 42))
    }
    
    @Test
    fun testGermanLocalization() {
        // Initialize with German locale
        I18n.init("de")
        
        // Test some strings
        assertEquals("Willkommen bei der Taschenrechner-App!", I18n.get("welcome"))
        assertEquals("Verwendung: Geben Sie durch Leerzeichen getrennte Zahlen ein, um sie zu addieren.", I18n.get("usage"))
        assertEquals("Geben Sie 'exit' ein, um zu beenden.", I18n.get("exit_instruction"))
        assertEquals("Ergebnis: 42", I18n.format("result", 42))
    }
}