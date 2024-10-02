package com.game.newsapplication.coordinator

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunaa.abc.coordinator.menu.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBarView(
    coordinatorViewModel: CoordinatorViewModel = viewModel()
) {
    // Observe the app bar text state from the ViewModel
    val appBarTextId by coordinatorViewModel.appBarTex.collectAsState()
    val isRoatated by coordinatorViewModel.isRotated.collectAsState()
    var isExpanded by remember { mutableStateOf(false) }

    val rotation = remember { androidx.compose.animation.core.Animatable(0f) }
    LaunchedEffect(isRoatated) {
        rotation.animateTo(
            targetValue = if (isRoatated) 90f else 0f,
            animationSpec = tween(durationMillis = 300) // Adjust duration as needed
        )
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(appBarTextId),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        actions = {
            IconButton(
                onClick = {
                    isExpanded = !isExpanded
                    coordinatorViewModel.updateRotationState()
                },
                modifier = Modifier
                    .padding(20.dp)
                    .rotate(rotation.value)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "more option"
                )
            }
            DropdownMenu(expanded = isExpanded,
                onDismissRequest = { isExpanded = false
                                   coordinatorViewModel.updateRotationState()},
                offset = DpOffset(-5.dp, 0.dp),
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                content = { MenuItem() })
        }
    )
}


