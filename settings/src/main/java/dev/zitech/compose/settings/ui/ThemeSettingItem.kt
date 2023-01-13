package dev.zitech.compose.settings.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import dev.zitech.compose.settings.R
import dev.zitech.compose.settings.model.ThemeOption

@Composable
fun ThemeSettingItem(
    modifier: Modifier,
    selectedTheme: ThemeOption,
    onOptionSelected: (option: ThemeOption) -> Unit
) {
    var dropDownExpanded by remember { mutableStateOf(false) }

    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .clickable(
                    onClickLabel = stringResource(id = R.string.cd_select_theme),
                    onClick = { dropDownExpanded = !dropDownExpanded }
                )
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = stringResource(id = R.string.settings_option_theme)
            )
            Text(text = stringResource(id = selectedTheme.label))
        }


        DropdownMenu(
            expanded = dropDownExpanded,
            onDismissRequest = { dropDownExpanded = false },
            offset = DpOffset(16.dp, 0.dp)
        ) {
            ThemeOption.values().forEach {
                DropdownMenuItem(onClick = {
                    onOptionSelected(it)
                    dropDownExpanded = false
                }) {
                    Text(text = stringResource(id = it.label))
                }
            }
        }
    }
}