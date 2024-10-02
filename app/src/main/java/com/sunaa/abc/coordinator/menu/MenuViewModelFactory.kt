package com.sunaa.abc.coordinator.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunaa.abc.coordinator.language.LocaleRepository

class MenuViewModelFactory(
    private val localeRepository: LocaleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MenuViewModel(localeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
