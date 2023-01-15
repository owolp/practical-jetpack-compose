package dev.zitech.compose.settings

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dev.zitech.compose.settings.Tags.TAG_MARKETING_OPTION
import dev.zitech.compose.settings.model.MarketingOption
import dev.zitech.compose.settings.ui.MarketingSettingItem
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class MarketingSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Marketing_Option_Selected() {
        val option = MarketingOption.ALLOWED
        with(composeTestRule) {
            setContent {
                MarketingSettingItem(
                    selectedOption = option,
                    onOptionSelected = {}
                )
            }

            onNodeWithTag(TAG_MARKETING_OPTION + option.id).assertIsSelected()
        }
    }

    @Test
    fun On_Setting_Clicked_Triggered() {
        val option = MarketingOption.ALLOWED
        val onOptionSelected = mockk<(MarketingOption) -> Unit>(relaxed = true)
        with(composeTestRule) {
            setContent {
                MarketingSettingItem(
                    selectedOption = option,
                    onOptionSelected = onOptionSelected
                )
            }
            onNodeWithTag(TAG_MARKETING_OPTION + MarketingOption.NOT_ALLOWED.id).performClick()
        }
        verify(exactly = 1) { onOptionSelected.invoke(MarketingOption.NOT_ALLOWED) }
    }
}