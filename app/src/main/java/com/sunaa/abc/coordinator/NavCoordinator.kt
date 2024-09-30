package com.game.newsapplication.coordinator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sunaa.abc.R
import com.sunaa.abc.ui.view.ScreenAuthorView
import com.sunaa.abc.ui.view.ScreenBooksView
import com.sunaa.abc.ui.view.ScreenReviewView


enum class NavInfo(
    val route: String,
    val navItemName: String,
    val iconId: Int
) {
    BOOKS("books", "Books", R.drawable.nav_books),
    AUTHORS("authors", "Authors", R.drawable.nav_author),
    REVIEWS("reviews", "Reviews", R.drawable.nav_reviews)
}

class NavCoordinator(
    val navController: NavHostController
) {
    var routeName: String = ""

    fun navigateTo(route: String) {
        routeName = route
        navController.navigate(route){
            // This ensures the back stack is cleared up to the home screen
            popUpTo(NavInfo.BOOKS.route) {
                inclusive = false // Keeps the home screen in the back stack
            }
            // Avoid re-adding the current destination to the back stack
            launchSingleTop = true

        }
    }

    @Composable
    fun NavigationHost(
        startDestination: String,
        coordinator: NavCoordinator,
        paddingValues: PaddingValues
    ) {
        NavHost(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            navController = coordinator.navController,
            startDestination = startDestination
        ) {
            composable(NavInfo.BOOKS.route) {
                ScreenBooksView()
            }
            composable(NavInfo.AUTHORS.route) {
                ScreenAuthorView()
            }
            composable(NavInfo.REVIEWS.route) {
                ScreenReviewView()
            }
        }

    }

    fun getNavItems(): List<NavInfo> {
        return listOf(NavInfo.BOOKS, NavInfo.AUTHORS, NavInfo.REVIEWS)
    }

    fun getCurrentScreenInfo(): String {
        return routeName
    }
}