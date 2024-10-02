package com.sunaa.abc.coordinator.language

import android.app.Activity
import android.content.Context
import java.util.Locale

class LocaleRepository(private val context: Context) {
    fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        LocaleHelper.updateLocale(context, locale)
    }
}
