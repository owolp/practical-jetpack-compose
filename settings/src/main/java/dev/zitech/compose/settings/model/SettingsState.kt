package dev.zitech.compose.settings.model

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.NOT_ALLOWED,
    val theme: Theme = Theme.SYSTEM
)