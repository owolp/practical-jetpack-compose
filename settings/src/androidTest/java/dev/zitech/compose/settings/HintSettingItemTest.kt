package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dev.zitech.compose.settings.Tags.TAG_CHECK_ITEM
import dev.zitech.compose.settings.ui.HintSettingItem
import org.junit.Rule
import org.junit.Test

class HintSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Is_Displayed() {
        val title = "Show Hints"
        with(composeTestRule) {
            setContent {
                HintSettingItem(
                    title = title,
                    checked = true,
                    onShowHintsToggled = {}
                )
            }

            onNodeWithText(title).assertIsDisplayed()
        }
    }

    @Test
    fun Setting_Is_Checked() {
        val title = "Show Hints"
        with(composeTestRule) {
            setContent {
                HintSettingItem(
                    title = title,
                    checked = true,
                    onShowHintsToggled = {}
                )
            }

            onNodeWithTag(TAG_CHECK_ITEM).assertIsOn()
        }
    }

    @Test
    fun Setting_Is_Not_Checked() {
        val title = "Show Hints"
        with(composeTestRule) {
            setContent {
                HintSettingItem(
                    title = title,
                    checked = false,
                    onShowHintsToggled = {}
                )
            }

            onNodeWithTag(TAG_CHECK_ITEM).assertIsOff()
        }
    }
}