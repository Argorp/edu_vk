package com.example.edu_vk.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repo: AppRepository
): ViewModel() {

    private val _apps = MutableStateFlow<List<App>>(emptyList())
    val apps: StateFlow<List<App>> = _apps.asStateFlow()
    private val _events = MutableSharedFlow<AppListEvent>()
    val events: SharedFlow<AppListEvent> = _events.asSharedFlow()

    init {
        _apps.value = repo.getAllApps()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppListEvent.ShowSnackbar("Это лого :)"))
        }
    }
}

sealed interface AppListEvent {
    data class ShowSnackbar(val message: String) : AppListEvent
}