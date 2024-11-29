package com.example.navigation1.navigation.nav_graph

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.navigation1.navigation.DETAIL_ARGUMENT_KEY
import com.example.navigation1.navigation.DETAIL_ARGUMENT_KEY2
import com.example.navigation1.navigation.HOME_ROUTE
import com.example.navigation1.navigation.Screen
import com.example.navigation1.screens.DetailScreen
import com.example.navigation1.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "NA"
                }
            )
        ) {
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController)
        }
    }

}