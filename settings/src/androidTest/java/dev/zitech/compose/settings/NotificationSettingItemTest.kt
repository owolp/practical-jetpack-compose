package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dev.zitech.compose.settings.Tags.TAG_TOGGLE_ITEM
import dev.zitech.compose.settings.ui.NotificationSettingItem
import org.junit.Rule
import org.junit.Test

class NotificationSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Is_Displayed() {
        val title = "Enable Notifications"
        with(composeTestRule) {
            setContent {
                NotificationSettingItem(
                    title = title,
                    checked = true,
                    onCheckedChanged = {}
                )
            }

            onNodeWithText(title).assertIsDisplayed()
        }
    }

    @Test
    fun Setting_Is_Checked() {
        val title = "Enable Notifications"
        with(composeTestRule) {
            setContent {
                NotificationSettingItem(
                    title = title,
                    checked = true,
                    onCheckedChanged = {}
                )
            }

            onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
        }
    }

    @Test
    fun Setting_Is_Not_Checked() {
        val title = "Enable Notifications"
        with(composeTestRule) {
            setContent {
                NotificationSettingItem(
                    title = title,
                    checked = false,
                    onCheckedChanged = {}
                )
            }

            onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOff()
        }
    }
}