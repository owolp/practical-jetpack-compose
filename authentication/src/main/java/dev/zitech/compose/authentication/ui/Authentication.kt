package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.zitech.compose.authentication.AuthenticationViewModel

@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()

    AuthenticationContent(
        modifier = Modifier.fillMaxWidth(),
        state = viewModel.uiState.collectAsState().value,
        handleEvent = viewModel::handleEvent
    )
}