package com.game.newsapplication.coordinator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoordinatorViewModel : ViewModel() {
    private val _appBarText = MutableStateFlow("Books")
    val appBarTex: StateFlow<String> = _appBarText.asStateFlow()


    private val _appThemeIsDark = MutableStateFlow(false)
    val appThemeIsDark: StateFlow<Boolean> = _appThemeIsDark.asStateFlow()

    fun updateText(newText: String) {
        _appBarText.value = newText
    }
    fun updateTheme(newValue : Boolean){
        _appThemeIsDark.value = newValue
    }
}