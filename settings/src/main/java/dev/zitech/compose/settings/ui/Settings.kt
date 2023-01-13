package dev.zitech.compose.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.zitech.compose.settings.R
import dev.zitech.compose.settings.SettingsViewModel
import dev.zitech.compose.settings.model.SettingsState

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    val state by viewModel.uiState.collectAsState()
    SettingsList(
        modifier = Modifier.fillMaxSize(),
        state = state,
        toggleNotificationSetting = viewModel::toggleNotificationSettings,
        toggleHintsSetting = viewModel::toggleHintSettings,
        showManageSubscription = viewModel::showManageSubscription
    )
}

@Composable
fun SettingsList(
    modifier: Modifier,
    state: SettingsState,
    toggleNotificationSetting: () -> Unit,
    toggleHintsSetting: () -> Unit,
    showManageSubscription: () -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back),
                tint = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.title_settings),
                fontSize = 18.sp,
                color = MaterialTheme.colors.onSurface
            )
        }

        NotificationSettings(
            modifier = modifier.fillMaxWidth(),
            title = stringResource(id = R.string.settings_enable_notifications),
            checked = state.notificationsEnabled,
            onCheckedChanged = { toggleNotificationSetting() }
        )
        Divider()
        HintSettingsItem(
            modifier = modifier.fillMaxWidth(),
            title = stringResource(id = R.string.settings_show_hints),
            checked = state.hintsEnabled,
            onShowHintsToggled = { toggleHintsSetting() }
        )
        Divider()
        ManageSubscriptionSettingItem(
            modifier = modifier.fillMaxWidth(),
            title = stringResource(id = R.string.settings_manage_subscription),
            onSettingsClicked = { showManageSubscription() }
        )
        Divider()
    }
}