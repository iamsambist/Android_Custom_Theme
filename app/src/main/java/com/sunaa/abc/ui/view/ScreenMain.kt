package com.sunaa.abc.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.game.newsapplication.coordinator.CoordinatorViewModel
import com.game.newsapplication.coordinator.NavCoordinator
import com.game.newsapplication.coordinator.NavInfo
import com.game.newsapplication.coordinator.ScreenBottomBarView
import com.game.newsapplication.coordinator.ScreenTopBarView
import com.sunaa.abc.ui.theme.ABCTheme

@Composable
fun ScreenMainView(
    coordinatorViewModel: CoordinatorViewModel = viewModel()
) {

    val isDarkTheme by coordinatorViewModel.appThemeIsDark.collectAsState()
    ABCTheme(isDarkTheme) {
        val navController = rememberNavController()
        val coordinator: NavCoordinator = remember { NavCoordinator(navController) }
        Scaffold(
            bottomBar = { ScreenBottomBarView(coordinator, coordinatorViewModel) },
            topBar = { ScreenTopBarView(coordinatorViewModel) }
        ) { innerPadding ->

            coordinator.NavigationHost(NavInfo.BOOKS.route, coordinator, innerPadding)
            /*
           * Now we need a function ( Since it composable so the other function has to be a Composable ) where
           *  we pass start destination with coordinator and padding values
           * so that each screen should adjust according  to padding values associated with bottom bar
           * */
        }
    }
}

@Composable
fun ScreenAuthorView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Author")
    }
}

@Composable
fun ScreenReviewView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Reviews")
    }
}
@Composable
fun ScreenBooksView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Books")
    }
}