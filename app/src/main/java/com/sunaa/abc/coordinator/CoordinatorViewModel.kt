package com.game.newsapplication.coordinator

import androidx.lifecycle.ViewModel
import com.sunaa.abc.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoordinatorViewModel() : ViewModel() {
    private val _appBarText = MutableStateFlow(R.string.appbar_book)
    val appBarTex: StateFlow<Int> = _appBarText.asStateFlow()


    private val _isRotated = MutableStateFlow(false)
    val isRotated: StateFlow<Boolean> = _isRotated.asStateFlow()

    fun updateText(newStringId: Int) {
        _appBarText.value = newStringId
    }

    fun updateRotationState() {
        _isRotated.value = !_isRotated.value
    }


}