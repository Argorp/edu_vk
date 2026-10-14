package com.example.edu_vk.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.edu_vk.presentation.appdetails.AppDetailsScreen
import com.example.edu_vk.presentation.applist.AppListScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AppList.route,
    ) {
        composable(route = Screen.AppList.route) {
            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(Screen.AppDetails.createRoute(appId))
                },
            )
        }

        composable(
            route = Screen.AppDetails.route,
            arguments = listOf(
                navArgument("appId") { type = NavType.IntType },
            ),
        ) { entry ->
            val appId = entry.arguments?.getInt("appId") ?: 0
            AppDetailsScreen(
                appId = appId,
                onBackClick = { navController.popBackStack() },
                onShowcaseAppClick = { showcaseAppId ->
                    navController.navigate(Screen.AppDetails.createRoute(showcaseAppId.toInt()))
                },
            )
        }
    }
}