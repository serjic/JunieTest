package ogr.junie.app

import java.util.*

/**
 * Internationalization (i18n) utility class for the calculator application.
 * Provides methods to get translated strings based on the current locale.
 */
object I18n {
    private const val BUNDLE_NAME = "i18n.messages"
    private var locale: Locale = Locale.getDefault()
    private var resourceBundle: ResourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale)

    /**
     * Sets the locale for the application.
     * @param locale The locale to use
     */
    fun setLocale(locale: Locale) {
        this.locale = locale
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale)
    }

    /**
     * Gets the current locale.
     * @return The current locale
     */
    fun getLocale(): Locale = locale

    /**
     * Gets a translated string for the given key.
     * @param key The key to look up
     * @return The translated string
     */
    fun getString(key: String): String {
        return try {
            resourceBundle.getString(key)
        } catch (e: MissingResourceException) {
            "!$key!"
        }
    }

    /**
     * Gets a translated string for the given key with parameters.
     * @param key The key to look up
     * @param args The parameters to substitute in the string
     * @return The translated string with parameters substituted
     */
    fun getString(key: String, vararg args: Any): String {
        val pattern = getString(key)
        return String.format(pattern, *args)
    }
}