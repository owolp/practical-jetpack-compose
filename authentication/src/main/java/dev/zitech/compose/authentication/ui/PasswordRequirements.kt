package dev.zitech.compose.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.zitech.compose.authentication.model.PasswordRequirement

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirement>
) {
    Column(
        modifier = modifier
    ) {
        PasswordRequirement.values().forEach { requirement ->
            Requirement(
                message = stringResource(id = requirement.label),
                satisfied = satisfiedRequirements.contains(requirement)
            )
        }
    }
}
