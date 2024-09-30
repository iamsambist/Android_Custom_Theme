package com.game.newsapplication.coordinator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBarView(
   coordinatorViewModel: CoordinatorViewModel
){
    // observe the text state here
    val appBarText by coordinatorViewModel.appBarTex.collectAsState()
    CenterAlignedTopAppBar(title = { Text(text = appBarText)},
        actions = {SwitchComposable(coordinatorViewModel = coordinatorViewModel)})
}

@Composable
fun SwitchComposable(
    modifier: Modifier = Modifier,
    coordinatorViewModel: CoordinatorViewModel
) {
    val isDarkTheme by coordinatorViewModel.appThemeIsDark.collectAsState()
    Switch(checked = isDarkTheme,
        modifier = Modifier.padding(20.dp),
        onCheckedChange = {newValue ->
           coordinatorViewModel.updateTheme(newValue)
        })
}
