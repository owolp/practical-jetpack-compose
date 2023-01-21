package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.zitech.compose.authentication.model.AuthenticationEvent
import dev.zitech.compose.authentication.model.AuthenticationState

@Composable
fun AuthenticationContent(
    modifier: Modifier,
    state: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                modifier = Modifier.fillMaxSize(),
                authenticationMode = state.authenticationMode,
                email = state.email,
                password = state.password,
                completedPasswordRequirements = state.passwordRequirements,
                enableAuthentication = state.isFormValid(),
                onEmailChanged = { email ->
                    handleEvent(AuthenticationEvent.EmailChanged(email))
                },
                onPasswordChanged = { password ->
                    handleEvent(AuthenticationEvent.PasswordChanged(password))
                },
                onAuthenticate = {
                    handleEvent(AuthenticationEvent.Authenticate)
                },
                onToggleMode = {
                    handleEvent(AuthenticationEvent.ToggleAuthenticationMode)
                }
            )
        }
    }
}