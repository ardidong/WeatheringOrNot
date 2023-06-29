package com.ardidong.weatherornot.app.presentation.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Muted000 = Color(255,255,255)
val Muted900 = Color(0,0,0)
// Rally is always dark themed.
val ColorPalette = lightColors(
    primary = Muted000,
    onPrimary = Muted900,
    surface = Muted000,
    onSurface = Muted900,
    background = Muted000,
    onBackground = Muted900
)
