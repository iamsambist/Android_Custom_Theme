package com.sunaa.abc.coordinator.menu

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.sunaa.abc.coordinator.language.LocaleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuViewModel(
    private val localeRepository: LocaleRepository
) : ViewModel() {
    private val  _isLanguageVisiable = MutableStateFlow(false)
    var isLanguageVisiable : StateFlow<Boolean> = _isLanguageVisiable.asStateFlow()

    private val _appThemeIsDark = MutableStateFlow(false)
    val appThemeIsDark: StateFlow<Boolean> = _appThemeIsDark.asStateFlow()

    private val _languageSeletedIndex = MutableStateFlow(0)
    var languageSeletedIndex : StateFlow<Int> = _languageSeletedIndex.asStateFlow()

    fun updateLanguageVisibility(){
        _isLanguageVisiable.value = !_isLanguageVisiable.value
    }

    fun updateTheme(){
        _appThemeIsDark.value = !_appThemeIsDark.value
    }
    fun updateSeletedLanguageIndex(newValue : Int){
        _languageSeletedIndex.value = newValue
    }
    fun updateLanguage(languageCode: String) {
        localeRepository.setLocale(languageCode)
    }



}