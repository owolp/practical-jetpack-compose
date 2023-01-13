package dev.zitech.compose.settings.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.zitech.compose.settings.R

@Composable
fun ManageSubscriptionSettingItem(
    modifier: Modifier = Modifier,
    title: String,
    onSettingsClicked: () -> Unit
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                // Set cd to the whole area, otherwise talkback will mention only the Icon cd (if not null)
                .clickable(
                    onClickLabel = stringResource(
                        id = R.string.cd_open_subscription
                    )
                ) { onSettingsClicked() }
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = title
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                // Add cd only when needed. For elements that are provided as decoration, pass null
                contentDescription = null // null, since Row has onClickLabel
            )
        }
    }
}