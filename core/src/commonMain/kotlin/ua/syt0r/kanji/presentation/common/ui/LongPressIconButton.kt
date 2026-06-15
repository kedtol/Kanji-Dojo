@file:OptIn(ExperimentalMaterial3Api::class)

package ua.syt0r.kanji.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun LongPressIconButton(
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    containerColor: Color = Color.Transparent,
    icon: @Composable () -> Unit
) {
    val indication = ripple(color = LocalRippleConfiguration.current?.color ?: Color.White)

    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            // the state layer size is 40 dp in original kotlin code,
            // this is hacky, but I don't know of a way to get this from the same source
            .size(40.dp)
            .clip(CircleShape)
            .background(color = containerColor)
            .combinedClickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = indication,
                onLongClick = onLongClick,
            ),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}
