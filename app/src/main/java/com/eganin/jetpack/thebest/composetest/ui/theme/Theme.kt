package com.eganin.jetpack.thebest.composetest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = Gray,
    onSurface=Blue,
    onBackground = Black,
    background = BlackTransparent,
    secondary = White
)

private val LightColorPalette = lightColors(
    primary = BlackTransparentDark,
    primaryVariant = GrayTransparentDark,
    onSurface = BlueDark,
    onBackground = WhiteDark,
    background = WhiteDark,
    secondary = WhiteTransparentDark
)

@Composable
fun ComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}