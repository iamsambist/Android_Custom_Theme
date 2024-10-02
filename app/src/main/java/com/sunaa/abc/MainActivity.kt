package com.sunaa.abc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.game.newsapplication.coordinator.CoordinatorViewModel
import com.sunaa.abc.coordinator.language.LocaleRepository
import com.sunaa.abc.coordinator.menu.MenuViewModel
import com.sunaa.abc.coordinator.menu.MenuViewModelFactory
import com.sunaa.abc.ui.view.ScreenMainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val localeRepository = LocaleRepository(this )
        val menuViewModel = ViewModelProvider(this, MenuViewModelFactory(localeRepository))
            .get(MenuViewModel::class.java)
        enableEdgeToEdge()
        setContent {
            ScreenMainView(menuViewModel = menuViewModel)
        }
    }
}
