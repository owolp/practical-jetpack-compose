package dev.zitech.compose.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.zitech.compose.authentication.model.AuthenticationEvent
import dev.zitech.compose.authentication.model.AuthenticationMode
import dev.zitech.compose.authentication.model.AuthenticationState
import dev.zitech.compose.authentication.model.PasswordRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
            is AuthenticationEvent.EmailChanged -> updateEmailAddress(authenticationEvent.emailAddress)
            is AuthenticationEvent.PasswordChanged -> updatePassword(authenticationEvent.password)
            AuthenticationEvent.Authenticate -> authenticate()
            AuthenticationEvent.ErrorDismissed -> dismissError()
        }
    }

    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (authenticationMode == AuthenticationMode.SIGN_IN) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(authenticationMode = newAuthenticationMode)
    }

    private fun updateEmailAddress(emailAddress: String) {
        uiState.value = uiState.value.copy(email = emailAddress)
    }

    private fun updatePassword(password: String) {
        if (uiState.value.authenticationMode == AuthenticationMode.SIGN_UP) {
            val requirements = mutableListOf<PasswordRequirement>()

            if (password.any { it.isUpperCase() }) {
                requirements.add(PasswordRequirement.CAPITAL_LETTER)
            }
            if (password.any { it.isDigit() }) {
                requirements.add(PasswordRequirement.NUMBER)
            }
            if (password.length > 7) {
                requirements.add(PasswordRequirement.EIGHT_CHARACTERS)
            }

            uiState.value = uiState.value.copy(
                password = password,
                passwordRequirements = requirements
            )
        } else {
            uiState.value = uiState.value.copy(password = password)
        }
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    error = "Something went wrong!"
                )
            }
        }
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(error = null)
    }
}