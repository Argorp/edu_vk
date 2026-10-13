package com.example.edu_vk.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.example.edu_vk.model.AppDetails
import com.example.edu_vk.model.SimilarApp


@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}