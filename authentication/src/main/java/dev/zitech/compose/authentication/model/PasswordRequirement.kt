package dev.zitech.compose.authentication.model

import androidx.annotation.StringRes
import dev.zitech.compose.authentication.R

enum class PasswordRequirement(@StringRes val label: Int) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters)
}