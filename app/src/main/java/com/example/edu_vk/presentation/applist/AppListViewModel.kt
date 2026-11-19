package com.example.edu_vk.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu_vk.domain.model.App
import com.example.edu_vk.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(val apps: List<App>) : AppListState
}

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repo: AppRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = MutableSharedFlow<AppListEvent>()
    val events: SharedFlow<AppListEvent> = _events.asSharedFlow()


    private val _ratings = MutableStateFlow<Map<String, Float>>(emptyMap())
    val ratings: StateFlow<Map<String, Float>> = _ratings.asStateFlow()

    private val _benchmarkResult = MutableStateFlow<String?>(null)
    val benchmarkResult: StateFlow<String?> = _benchmarkResult.asStateFlow()

    fun testPoslepovatelno(apps: List<App>) {
        viewModelScope.launch {
            _benchmarkResult.value = "Загрузка (последовательно) -_- "
            val ids = apps.map { it.id }
            val (result, time) = repo.Poslepovatelno(ids)
            _ratings.value = result
            _benchmarkResult.value = "Итого последовательно: $time мс"
        }
    }

    fun testPrallelno(apps: List<App>) {
        viewModelScope.launch {
            _benchmarkResult.value = "Загрузка (параллельно) ;) "
            val ids = apps.map { it.id }
            val (result, time) = repo.Prallelno(ids)
            _ratings.value = result
            _benchmarkResult.value = "Параллельно: $time мс"
        }
    }


    init {
        loadCatalog()
    }

    fun loadCatalog() {
        viewModelScope.launch {
            _state.value = AppListState.Loading
            try {
                val apps = repo.getAllApps()
                _state.value = AppListState.Content(apps)
            } catch (e: Exception) {
                android.util.Log.e("NETWORK_ERROR", "Нет доступа в Интернет", e)
                _state.value = AppListState.Error
            }
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppListEvent.ShowSnackbar("Это лого! :0"))
        }
    }
}

sealed interface AppListEvent {
    data class ShowSnackbar(val message: String) : AppListEvent
}