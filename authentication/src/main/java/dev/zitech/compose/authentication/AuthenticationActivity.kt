package dev.zitech.compose.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.zitech.compose.authentication.ui.Authentication
import dev.zitech.compose.authentication.ui.theme.AuthenticationTheme

class AuthenticationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthenticationTheme {
                Authentication()
            }
        }
    }
}