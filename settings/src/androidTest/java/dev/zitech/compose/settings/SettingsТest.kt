package dev.zitech.compose.settings

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import dev.zitech.compose.settings.Tags.TAG_CHECK_ITEM
import dev.zitech.compose.settings.Tags.TAG_MARKETING_OPTION
import dev.zitech.compose.settings.Tags.TAG_TOGGLE_ITEM
import dev.zitech.compose.settings.ui.Settings
import org.junit.Rule
import org.junit.Test

class SettingsТest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Enable_Notifications_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_enable_notifications)
    }

    @Test
    fun Enable_Notifications_Settings_Toggles_Selected_State() {
        with(composeTestRule) {
            setContent {
                Settings()
            }
            onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOff()
            onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(
                        R.string.settings_enable_notifications
                    )
            ).performClick()
            onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
        }
    }

    @Test
    fun Show_Hints_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_show_hints)
    }

    @Test
    fun Show_Hints_Settings_Toggles_Selected_State() {
        with(composeTestRule) {
            setContent {
                Settings()
            }
            onNodeWithTag(TAG_CHECK_ITEM).assertIsOff()
            onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(
                        R.string.settings_show_hints
                    )
            ).performClick()
            onNodeWithTag(TAG_CHECK_ITEM).assertIsOn()
        }
    }

    @Test
    fun Manage_Subscription_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_manage_subscription)
    }

    @Test
    fun Marketing_Option_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_option_marketing)
    }

    @Test
    fun Marketing_Option_Toggles_Selected_State() {
        with(composeTestRule) {
            setContent {
                Settings()
            }
            onNodeWithTag(TAG_MARKETING_OPTION + 0).assertIsSelected()
            onNodeWithTag(TAG_MARKETING_OPTION + 1).assertIsNotSelected()
            onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.resources.getStringArray(
                        R.array.settings_options_marketing_choice
                    )[1]
            ).performClick()
            onNodeWithTag(TAG_MARKETING_OPTION + 0).assertIsNotSelected()
            onNodeWithTag(TAG_MARKETING_OPTION + 1).assertIsSelected()
        }
    }

    @Test
    fun Theme_Option_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_option_theme)
    }

    @Test
    fun AppVersion_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.settings_app_version_title)
    }

    private fun assertSettingIsDisplayed(
        @StringRes title: Int
    ) {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(
                    title
                )
        ).assertIsDisplayed()
    }
}