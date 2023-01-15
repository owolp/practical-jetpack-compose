package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dev.zitech.compose.settings.Tags.TAG_CHECK_ITEM
import dev.zitech.compose.settings.ui.AppVersionSettingItem
import dev.zitech.compose.settings.ui.HintSettingItem
import org.junit.Rule
import org.junit.Test

class AppVersionSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Version_Is_Displayed() {
        val version = "v1.2.3"
        with(composeTestRule) {
            setContent {
                AppVersionSettingItem(
                    appVersion = version
                )
            }

            onNodeWithText(version).assertIsDisplayed()
        }
    }
}