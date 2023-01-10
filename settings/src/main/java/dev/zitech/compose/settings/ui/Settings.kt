package dev.zitech.compose.settings.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.zitech.compose.settings.SettingsViewModel
import dev.zitech.compose.settings.model.SettingsState

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    val state by viewModel.uiState.collectAsState()
}

@Composable
fun SettingsList(
    modifier: Modifier,
    state: SettingsState
) {

}