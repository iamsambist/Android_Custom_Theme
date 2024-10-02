package com.game.newsapplication.coordinator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun ScreenBottomBarView(
    coordinator: NavCoordinator,
    coordinatorViewModel: CoordinatorViewModel
) {

    NavigationBar(
        modifier = Modifier
            .navigationBarsPadding()
            .background(Color.DarkGray)
    ) {
        coordinator.getNavItems().forEachIndexed { index, navInfo ->
            val isSelected =
                coordinator.navController.currentBackStackEntryAsState().value?.destination?.route == navInfo.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        coordinatorViewModel.updateText(navInfo.appBarTextId)
                        coordinator.navigateTo(navInfo.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(navInfo.iconId),
                        contentDescription = "Books"
                    )
                },
                label = {
                    Text(text = stringResource(navInfo.navItemName))
                },
                alwaysShowLabel = false
            )
        }
    }
}