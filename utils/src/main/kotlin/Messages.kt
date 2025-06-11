package ogr.junie.utils

import java.util.*
import java.io.InputStream

/**
 * A utility class for handling internationalization (i18n) in the application.
 * Provides methods to load and retrieve localized strings from resource bundles.
 */
class Messages(private val locale: Locale = Locale.getDefault()) {
    private val bundle: ResourceBundle by lazy {
        try {
            ResourceBundle.getBundle("messages", locale)
        } catch (e: MissingResourceException) {
            // Fallback to default locale if the requested locale is not available
            ResourceBundle.getBundle("messages", Locale.ENGLISH)
        }
    }

    /**
     * Gets a localized message for the given key.
     *
     * @param key The message key
     * @return The localized message
     */
    fun get(key: String): String {
        return try {
            bundle.getString(key)
        } catch (e: MissingResourceException) {
            // Return the key itself if the message is not found
            key
        }
    }

    /**
     * Gets a localized message for the given key with parameter substitution.
     *
     * @param key The message key
     * @param params The parameters to substitute in the message
     * @return The localized message with parameters substituted
     */
    fun get(key: String, vararg params: Any): String {
        val message = get(key)
        return if (params.isEmpty()) message else String.format(message, *params)
    }

    companion object {
        private val instances = mutableMapOf<Locale, Messages>()

        /**
         * Gets a Messages instance for the given locale.
         *
         * @param locale The locale
         * @return A Messages instance for the given locale
         */
        fun forLocale(locale: Locale): Messages {
            return instances.getOrPut(locale) { Messages(locale) }
        }

        /**
         * Gets a Messages instance for the default locale.
         *
         * @return A Messages instance for the default locale
         */
        fun default(): Messages {
            return forLocale(Locale.getDefault())
        }

        /**
         * Gets a Messages instance for German locale.
         *
         * @return A Messages instance for German locale
         */
        fun german(): Messages {
            return forLocale(Locale.GERMAN)
        }

        /**
         * Gets a Messages instance for English locale.
         *
         * @return A Messages instance for English locale
         */
        fun english(): Messages {
            return forLocale(Locale.ENGLISH)
        }
    }
}