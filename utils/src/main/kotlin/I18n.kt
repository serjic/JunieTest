package ogr.junie.utils

import java.util.*
import java.text.MessageFormat

/**
 * Internationalization utility class for handling localized strings.
 */
class I18n {
    companion object {
        private var locale: Locale = Locale.getDefault()
        private var resourceBundle: ResourceBundle? = null
        
        /**
         * Initialize the internationalization system with the specified locale.
         * 
         * @param localeCode The locale code (e.g., "en", "de")
         */
        fun init(localeCode: String) {
            locale = Locale(localeCode)
            resourceBundle = ResourceBundle.getBundle("Messages", locale)
        }
        
        /**
         * Get a localized string for the given key.
         * 
         * @param key The key for the localized string
         * @return The localized string or the key itself if not found
         */
        fun get(key: String): String {
            if (resourceBundle == null) {
                init(locale.language)
            }
            
            return try {
                resourceBundle?.getString(key) ?: key
            } catch (e: MissingResourceException) {
                key
            }
        }
        
        /**
         * Get a localized string with formatted arguments.
         * 
         * @param key The key for the localized string
         * @param args The arguments to format into the string
         * @return The formatted localized string
         */
        fun format(key: String, vararg args: Any): String {
            val pattern = get(key)
            return MessageFormat.format(pattern, *args)
        }
        
        /**
         * Get the current locale.
         * 
         * @return The current locale
         */
        fun getLocale(): Locale {
            return locale
        }
    }
}