package com.example.edu_vk.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.example.edu_vk.domain.model.App


@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: App,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}