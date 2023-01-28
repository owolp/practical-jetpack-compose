package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import dev.zitech.compose.authentication.Tags
import dev.zitech.compose.authentication.model.AuthenticationMode
import dev.zitech.compose.authentication.model.PasswordRequirement

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    password: String?,
    completedPasswordRequirements: List<PasswordRequirement>,
    enableAuthentication: Boolean,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (email: String) -> Unit,
    onAuthenticate: () -> Unit,
    onToggleMode: () -> Unit
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
            authenticationMode = authenticationMode,
            completedPasswordRequirements = completedPasswordRequirements,
            enableAuthentication = enableAuthentication,
            onEmailChanged = onEmailChanged,
            onPasswordChanged = onPasswordChanged,
            onDoneClicked = onAuthenticate,
            onAuthenticate = onAuthenticate,
        )

        Spacer(modifier = Modifier.weight(1F))

        ToggleAuthenticationMode(
            modifier = Modifier.fillMaxWidth(),
            authenticationMode = authenticationMode,
            toggleAuthentication = onToggleMode
        )
    }
}