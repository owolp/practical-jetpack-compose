package dev.zitech.compose.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.zitech.compose.settings.R
import dev.zitech.compose.settings.Tags.TAG_MARKETING_OPTION
import dev.zitech.compose.settings.model.MarketingOption
import dev.zitech.compose.settings.model.MarketingOption.ALLOWED
import dev.zitech.compose.settings.model.MarketingOption.NOT_ALLOWED

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.settings_options_marketing_choice)

    SettingItem(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.settings_option_marketing))
            Spacer(modifier = Modifier.height(16.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .testTag(TAG_MARKETING_OPTION + index)
                        .fillMaxWidth()
                        // Clickable is not used here, instead use selectable, so that talkback can provide better accessibility info
//                        .clickable(onClickLabel = option) {
//                            onOptionSelected(
//                                when (index) {
//                                    ALLOWED.id -> ALLOWED
//                                    NOT_ALLOWED.id -> NOT_ALLOWED
//                                    else -> throw UnsupportedOperationException("index:$index not supported")
//                                }
//                            )
//                        }
                        .selectable(
                            selected = selectedOption.id == index,
                            onClick = {
                                onOptionSelected(
                                    when (index) {
                                        ALLOWED.id -> ALLOWED
                                        NOT_ALLOWED.id -> NOT_ALLOWED
                                        else -> throw UnsupportedOperationException("index:$index not supported")
                                    }
                                )
                            },
                            role = Role.RadioButton
                        )
                        .padding(10.dp)
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 18.dp),
                        text = option
                    )
                }
            }
        }
    }
}