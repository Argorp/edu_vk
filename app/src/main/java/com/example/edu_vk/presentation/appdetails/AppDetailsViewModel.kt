package com.example.edu_vk.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu_vk.data.samplesApp
import com.example.edu_vk.model.AppDetails
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel : ViewModel() {
    // TODO: добавить сообщение при нажатии на иконку и добавить иконку при заходе в детали приложения
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private var curApp: Int? = null
    public fun load(appId: Int) {
        if (curApp == appId && _state.value is AppDetailsState.Content)
            return
        curApp = appId
        _state.value = AppDetailsState.Loading

        viewModelScope.launch {
            delay(3.seconds)
            val allApps = (samplesApp + showcaseApps).distinctBy { it.id }
            val currentApp = allApps.find { it.id == appId }

            if (currentApp != null) {
                _state.value = AppDetailsState.Content(
                    appDetails = AppDetails(
                        id = currentApp.id,
                        name = currentApp.name,
                        developer = "Someone",
                        shortDescription = currentApp.shortDescription,
                        fullDescription = currentApp.fullDescription,
                        icon = currentApp.icon,
                        category = currentApp.category,
                        ageRating = currentApp.ageRating,
                        size = currentApp.size,
                    ),
                    descriptionCollapsed = true,
                    similarApps = emptyList()
                )
            } else {
                _state.value = AppDetailsState.Error
            }
        }
    }
    fun expandDescription() {
        val currentState = _state.value
        if (currentState is AppDetailsState.Content) {
            _state.value = currentState.copy(descriptionCollapsed = false)
        }
    }
}