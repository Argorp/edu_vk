package com.example.edu_vk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.applist.ui.AppListScreen

private val Accent = Color(0xFF6750A4)
private val AccentDark = Color(0xFFB69DF8)
private val LightColors = lightColorScheme(primary = Accent)
private val DarkColors = darkColorScheme(primary = AccentDark)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
            MaterialTheme(colorScheme = colors) {
                Surface {
                    AppListScreen()
                }
            }
        }
    }
}