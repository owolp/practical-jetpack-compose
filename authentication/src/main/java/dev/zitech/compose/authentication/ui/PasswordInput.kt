package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import dev.zitech.compose.authentication.R

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String?,
    onPasswordChanged: (password: String) -> Unit
) {
    var isPasswordHidden by remember { mutableStateOf(true) }

    TextField(
        modifier = modifier,
        value = password.orEmpty(),
        onValueChange = onPasswordChanged,
        label = {
            Text(text = stringResource(id = R.string.label_password))
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .clickable(
                        onClick = {
                            isPasswordHidden = !isPasswordHidden
                        },
                        onClickLabel = stringResource(
                            id = if (isPasswordHidden) {
                                R.string.cd_show_password
                            } else {
                                R.string.cd_hide_password
                            }
                        )
                    ),
                imageVector = if (isPasswordHidden) {
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                },
                contentDescription = null
            )
        },
        visualTransformation = if (isPasswordHidden) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}