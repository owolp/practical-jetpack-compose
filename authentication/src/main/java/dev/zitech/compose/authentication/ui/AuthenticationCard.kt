package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthenticationCard(
    modifier: Modifier = Modifier,
    email: String?,
    password: String?,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (email: String) -> Unit
) {
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
                onEmailChanged = onEmailChanged
            )
            Spacer(modifier = modifier.height(8.dp))
            PasswordInput(
                modifier = Modifier.fillMaxWidth(),
                password = password,
                onPasswordChanged = onPasswordChanged
            )
        }
    }
}