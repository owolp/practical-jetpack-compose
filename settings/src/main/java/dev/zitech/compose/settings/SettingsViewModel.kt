package dev.zitech.compose.settings

import androidx.lifecycle.ViewModel
import dev.zitech.compose.settings.model.MarketingOption
import dev.zitech.compose.settings.model.SettingsState
import dev.zitech.compose.settings.model.ThemeOption
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings() {
        uiState.value =
            uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintSettings() {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun setMarketingSettings(option: MarketingOption) {
        uiState.value = uiState.value.copy(marketingOption = option)
    }

    fun setTheme(option: ThemeOption) {
        uiState.value = uiState.value.copy(themeOption = option)
    }

    fun showManageSubscription() {
        // TODO:
    }
}