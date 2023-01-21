package dev.zitech.compose.authentication.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import dev.zitech.compose.authentication.model.AuthenticationMode
import dev.zitech.compose.authentication.model.PasswordRequirement

@Composable
fun AuthenticationCard(
    modifier: Modifier = Modifier,
    email: String?,
    password: String?,
    authenticationMode: AuthenticationMode,
    completedPasswordRequirements: List<PasswordRequirement>,
    enableAuthentication: Boolean,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (email: String) -> Unit,
    onDoneClicked: () -> Unit,
    onAuthenticate: () -> Unit,
) {
    val focusRequester = FocusRequester()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailInput(
                modifier = Modifier.fillMaxWidth(),
                email = email,
                onEmailChanged = onEmailChanged,
                onNextClicked = {
                    focusRequester.requestFocus()
                }
            )
            Spacer(modifier = modifier.height(8.dp))
            PasswordInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                password = password,
                onPasswordChanged = onPasswordChanged,
                onDoneClicked = onDoneClicked
            )
            Spacer(modifier = Modifier.height(12.dp))
            AnimatedVisibility(
                visible = authenticationMode == AuthenticationMode.SIGN_UP
            ) {
                PasswordRequirements(
                    modifier = Modifier.fillMaxWidth(),
                    satisfiedRequirements = completedPasswordRequirements
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            AuthenticationButton(
                authenticationMode = authenticationMode,
                enableAuthentication = enableAuthentication,
                onAuthenticate = onAuthenticate
            )
        }
    }
}