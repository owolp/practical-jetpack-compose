package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.zitech.compose.authentication.R

@Composable
fun Requirement(
    modifier: Modifier = Modifier,
    message: String,
    satisfied: Boolean
) {
    val tint: Color
    val requirementStatus: String

    if (satisfied) {
        tint = MaterialTheme.colors.primary
        requirementStatus = stringResource(id = R.string.cd_requirement_satisfied, message)
    } else {
        tint = MaterialTheme.colors.onSurface.copy(alpha = 0.4F)
        requirementStatus = stringResource(id = R.string.cd_requirement_needed, message)
    }

    Row(
        modifier = modifier
            .padding(6.dp)
            .semantics(mergeDescendants = true) {
                // Using text here, since the Row doesn't have state and stateDescription is not applicable
                text = AnnotatedString(requirementStatus)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(12.dp),
            imageVector = Icons.Default.Check,
            tint = tint,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            // Since semantics are provided by the parent, the Text once should be removed
            modifier = Modifier.clearAndSetSemantics { },
            text = message,
            fontSize = 12.sp,
            color = tint
        )
    }
}