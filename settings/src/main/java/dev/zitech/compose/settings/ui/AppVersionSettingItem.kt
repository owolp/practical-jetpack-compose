package dev.zitech.compose.settings.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import dev.zitech.compose.settings.R

@Composable
fun AppVersionSettingItem(
    modifier: Modifier = Modifier,
    appVersion: String
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                // mergeDescendants will allow talkback to read this Row as `App Version 1.0`, and not `App Version` and `1.0`
                .semantics(mergeDescendants = true) {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = stringResource(id = R.string.settings_app_version_title)
            )
            Text(text = appVersion)
        }
    }
}
