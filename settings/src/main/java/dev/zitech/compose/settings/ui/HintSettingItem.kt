package dev.zitech.compose.settings.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import dev.zitech.compose.settings.R

@Composable
fun HintSettingItem(
    modifier: Modifier,
    title: String,
    checked: Boolean,
    onShowHintsToggled: (checked: Boolean) -> Unit
) {
    val hintsEnabledState = stringResource(
        id = if (checked) {
            R.string.cd_hints_enabled
        } else {
            R.string.cd_hints_disabled
        }
    )
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                // use toggleable, to make the whole Row clickable
                .toggleable(
                    value = checked,
                    onValueChange = onShowHintsToggled,
                    role = Role.Checkbox
                )
                .semantics { // describe the current state of the composable when using talkback
                    stateDescription = hintsEnabledState
                }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = title
            )
            Checkbox(
                checked = checked,
                onCheckedChange = null // not needed since already used by toggleable
            )
        }
    }
}