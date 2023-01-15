package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.zitech.compose.settings.Tags.TAG_CHECK_ITEM
import dev.zitech.compose.settings.ui.HintSettingItem
import dev.zitech.compose.settings.ui.ManageSubscriptionSettingItem
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class ManageSubscriptionItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Is_Displayed() {
        val title = "Manage Subscription"
        with(composeTestRule) {
            setContent {
                ManageSubscriptionSettingItem(
                    title = title,
                    onSettingsClicked = {}
                )
            }

            onNodeWithText(title).assertIsDisplayed()
        }
    }

    @Test
    fun On_Setting_Clicked_Triggered() {
        val title = "Manage Subscription"
        val onSettingsClicked = mockk<() -> Unit>(relaxed = true)
        with(composeTestRule) {
            setContent {
                ManageSubscriptionSettingItem(
                    title = title,
                    onSettingsClicked = onSettingsClicked
                )
            }
            onNodeWithText(title).performClick()
        }
        verify(exactly = 1) { onSettingsClicked.invoke() }
    }
}