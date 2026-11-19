package com.example.edu_vk.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val repo: AppRepository
): ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val _showcaseApps = MutableStateFlow<List<App>>(emptyList())
    val showcaseApps: StateFlow<List<App>> = _showcaseApps.asStateFlow()

    private val _events = MutableSharedFlow<AppDetailsEvent>()
    val events: SharedFlow<AppDetailsEvent> = _events.asSharedFlow()

    private var currentAppId: String? = null

    fun load(appId: String) {
        if (currentAppId == appId && _state.value is AppDetailsState.Content) return

        currentAppId = appId
        _state.value = AppDetailsState.Loading

        viewModelScope.launch {
            try {
                val app = repo.getAppById(appId)
                val allApps = repo.getAllApps()
                _showcaseApps.value = allApps.take(9)

                if (app != null) {
                    _state.value = AppDetailsState.Content(app, descriptionCollapsed = true)
                } else {
                    _state.value = AppDetailsState.Error
                }
            } catch (e: Exception) {
                _state.value = AppDetailsState.Error
            }
        }
    }

    private var installJob: Job? = null

    fun onInstallClick() {
        val cur_state = _state.value
        if (cur_state !is AppDetailsState.Content)
            return

        if (cur_state.installState is InstallState.Installing) {
            installJob?.cancel()
            _state.update {
                if (it is AppDetailsState.Content)
                    it.copy(installState = InstallState.NotInstalled)
                else
                    it
            }
        } else {
            installJob = viewModelScope.launch {
                emulateInstall()
            }
        }
    }

    private suspend fun emulateInstall() {
        try {
            for (progress in 0..100 step 5) {
                _state.update {
                    if (it is AppDetailsState.Content)
                        it.copy(installState = InstallState.Installing(progress))
                    else
                        it
                }
                delay(duration = 3.seconds)
            }
        } catch (e: CancellationException) {
            throw e
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