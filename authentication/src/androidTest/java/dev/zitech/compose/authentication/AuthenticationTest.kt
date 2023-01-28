package dev.zitech.compose.authentication

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isEnabled
import androidx.compose.ui.test.isNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import dev.zitech.compose.authentication.ui.Authentication
import org.junit.Rule
import org.junit.Test

class AuthenticationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Sign_In_Title_Displayed_By_Default() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithText(getString(R.string.label_sign_in_to_account))
                .assertIsDisplayed()
        }
    }

    @Test
    fun Need_Account_Is_Displayed_By_Default() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithText(getString(R.string.action_need_account))
                .assertIsDisplayed()
        }
    }

    @Test
    fun Sign_Up_Title_Is_Displayed_After_Toggle() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithText(getString(R.string.action_need_account))
                .performClick()
            onNodeWithText(getString(R.string.label_sign_up_for_account))
                .assertIsDisplayed()
        }
    }

    @Test
    fun Sign_Up_Button_Is_Displayed_After_Toggle() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithText(getString(R.string.action_need_account))
                .performClick()
            onNodeWithTag(Tags.TAG_AUTHENTICATE_BUTTON)
                .assertTextEquals(getString(R.string.action_sign_up))
        }
    }

    @Test
    fun Already_Have_Account_Displayed_After_Toggle() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithTag(Tags.TAG_AUTHENTICATION_TOGGLE).apply {
                performClick()
                assertTextEquals(getString(R.string.action_already_have_account))
            }
        }
    }

    @Test
    fun Authentication_Button_Is_Disabled_By_Default() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithTag(Tags.TAG_AUTHENTICATE_BUTTON).apply {
                isNotEnabled()
            }
        }
    }

    @Test
    fun Authentication_Button_Is_Enabled_With_Valid_Content() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithTag(Tags.TAG_INPUT_EMAIL).apply {
                performTextInput("test@test.com")
            }
            onNodeWithTag(Tags.TAG_INPUT_PASSWORD).apply {
                performTextInput("password")
            }
            onNodeWithTag(Tags.TAG_AUTHENTICATE_BUTTON).apply {
                isEnabled()
            }
        }
    }

    @Test
    fun Error_Alert_Not_Displayed_By_Default() {
        with(composeTestRule) {
            setContent {
                Authentication()
            }
            onNodeWithTag(Tags.TAG_ERROR_ALERT).apply {
                assertDoesNotExist()
            }
        }
    }

    private fun getString(@StringRes id: Int): String =
        InstrumentationRegistry.getInstrumentation()
            .targetContext.getString(id)
}