package com.example.edu_vk.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu_vk.domain.repository.AppRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val _events = MutableSharedFlow<AppDetailsEvent>()
    val events: SharedFlow<AppDetailsEvent> = _events.asSharedFlow()

    private var currentAppId: Int? = null

    private val repo = AppRepositoryImpl()

    fun load(appId: Int) {
        if (currentAppId == appId && _state.value is AppDetailsState.Content) return

        currentAppId = appId
        _state.value = AppDetailsState.Loading

        viewModelScope.launch {
            delay(3.seconds)

            val app = repo.getAppById(appId)

            if (app != null) {
                _state.value = AppDetailsState.Content(
                    appDetails = app,
                    descriptionCollapsed = true,
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

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppDetailsEvent.ShowSnackbar("Это иконка !!!"))
        }
    }
}

sealed interface AppDetailsEvent {
    data class ShowSnackbar(val message: String) : AppDetailsEvent
}