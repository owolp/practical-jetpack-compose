package dev.zitech.compose.authentication.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import dev.zitech.compose.authentication.R
import dev.zitech.compose.authentication.Tags
import dev.zitech.compose.authentication.model.AuthenticationMode

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    enableAuthentication: Boolean,
    onAuthenticate: () -> Unit
) {
    Button(
        modifier = modifier
            .testTag(Tags.TAG_AUTHENTICATE_BUTTON),
        enabled = enableAuthentication,
        onClick = onAuthenticate,
    ) {
        Text(
            text = stringResource(
                id = when (authenticationMode) {
                    AuthenticationMode.SIGN_UP -> R.string.action_sign_up
                    AuthenticationMode.SIGN_IN -> R.string.action_sign_in
                }
            )
        )
    }
}