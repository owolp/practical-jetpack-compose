package dev.zitech.compose.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.zitech.compose.settings.ui.Settings
import dev.zitech.compose.settings.ui.theme.SettingsTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsTheme {
                Settings()
            }
        }
    }
}