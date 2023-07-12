package com.ardidong.weatherornot.app.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun WeatherOrNotTheme(content : @Composable () -> Unit) {
    MaterialTheme(colors = ColorPalette, content = content)
}