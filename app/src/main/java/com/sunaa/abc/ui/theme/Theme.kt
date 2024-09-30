package com.sunaa.abc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = Color.White, //  The default background color for the app, typically covering the entire screen
    onBackground = Color.Black, // Text/icons that appear on the background color.
    surface = Color.LightGray, // Used for cards, sheets, and other surfaces that overlay the background.
    onSurface = Color.White, //Text/icons that appear on the surface color
    primary = Color.Black, // For primary buttons, highlighted text, and primary interactive elements.
    onPrimary = Color.White, //color is used for text/icons that appear on top of the primary color.

    primaryContainer = Color.DarkGray, // A container color that complements the primary color surfaces like cards or dialogs.
    onPrimaryContainer = Color.White, // Text/icons that are displayed on top of the primaryContainer color.

    secondary = Color.Black, // This is useful for less prominent buttons or links.
    onSecondary = Color.White, // Text/icons on the secondary color.



)

private val LightColorScheme = lightColorScheme(
    background = Color.Black, //  The default background color for the app, typically covering the entire screen
    onBackground = Color.White, // Text/icons that appear on the background color.
    surface = Color.White, // Used for cards, sheets, and other surfaces that overlay the background.
    onSurface = Color.Black, //Text/icons that appear on the surface color
    primary = Color.White, // For primary buttons, highlighted text, and primary interactive elements.
    onPrimary = Color.Black, //color is used for text/icons that appear on top of the primary color.

    primaryContainer = Color.White, // A container color that complements the primary color surfaces like cards or dialogs.
    onPrimaryContainer = Color.Black, // Text/icons that are displayed on top of the primaryContainer color.

    secondary = Color.White, // This is useful for less prominent buttons or links.
    onSecondary = Color.Black, // Text/icons on the secondary color.
)

@Composable
fun ABCTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colors = if (isDarkTheme) {

    darkColorScheme() // Your dark color scheme
} else {
    lightColorScheme() // Your light color scheme
}

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}