package dev.zitech.compose.authentication.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.zitech.compose.authentication.R
import dev.zitech.compose.authentication.model.AuthenticationMode

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
) {
    Text(
        modifier = modifier,
        text = stringResource(
            id = when (authenticationMode) {
                AuthenticationMode.SIGN_UP -> R.string.label_sign_up_for_account
                AuthenticationMode.SIGN_IN -> R.string.label_sign_in_to_account
            }
        ),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}