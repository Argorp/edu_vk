package com.example.edu_vk.navigation

sealed class Screen(val route: String) {
    data object AppList : Screen("app_list")
    data object AppDetails : Screen("app_details/{appId}") {
        fun createRoute(appId: Int): String = "app_details/$appId"
    }
}