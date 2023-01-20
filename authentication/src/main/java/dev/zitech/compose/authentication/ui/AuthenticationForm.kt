package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.zitech.compose.authentication.model.AuthenticationMode

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    password: String?,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (email: String) -> Unit,
    onAuthenticate: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(40.dp))
        AuthenticationCard(
            email = email,
            password = password,
            onEmailChanged = onEmailChanged,
            onPasswordChanged = onPasswordChanged,
            onDoneClicked = onAuthenticate
        )
    }
}