package com.sunaa.abc.coordinator.language

import android.app.Activity
import android.content.Context
import java.util.Locale

object LocaleHelper {
    fun updateLocale(context: Context, locale: Locale) {
        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)

        // Update configuration for the current context
        context.createConfigurationContext(configuration)

        // Update the application's resources with the new locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        (context as Activity).recreate()

    }

}
