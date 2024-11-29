package com.example.navigation1.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation1.navigation.HOME_ROUTE
import com.example.navigation1.navigation.ROOT_ROUTE

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ) {
        // Home Navigation
        homeNavGraph(navController = navController)

        // Nested Navigation
        authNavGraph(navController = navController)
    }
}