package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import dev.zitech.compose.settings.Tags.TAG_CHECK_ITEM
import dev.zitech.compose.settings.Tags.TAG_SELECT_THEME
import dev.zitech.compose.settings.Tags.TAG_THEME_OPTION
import dev.zitech.compose.settings.model.ThemeOption
import dev.zitech.compose.settings.ui.HintSettingItem
import dev.zitech.compose.settings.ui.ThemeSettingItem
import org.junit.Rule
import org.junit.Test

class ThemeSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Is_Displayed() {
        val title = "Theme"
        val value = "System"
        val option = ThemeOption.SYSTEM
        with(composeTestRule) {
            setContent {
                ThemeSettingItem(
                    selectedTheme = option,
                    onOptionSelected = {},
                )
            }

            onNodeWithText(title).assertIsDisplayed()
            onNodeWithText(value).assertIsDisplayed()
        }
    }

    @Test
    fun Theme_Option_Is_Displayed() {
        val option = ThemeOption.SYSTEM
        with(composeTestRule) {
            setContent {
                ThemeSettingItem(
                    selectedTheme = option,
                    onOptionSelected = {}
                )
            }

            onNodeWithTag(TAG_SELECT_THEME).performClick()
            ThemeOption.values().forEach { theme ->
                onNodeWithTag(
                    TAG_THEME_OPTION + InstrumentationRegistry.getInstrumentation().targetContext.getString(
                        theme.label
                    )
                ).assertIsDisplayed()
            }
        }
    }
}