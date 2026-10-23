
package com.example.lab_7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    val races = remember {
        mutableStateListOf<String>()
    }

    val drivers = remember {
        mutableStateListOf<String>()
    }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }

        composable("races") {
            UpcomingRacesScreen(navController, races)
        }

        composable("drivers") {
            DriversScreen(navController, drivers)
        }
    }
}
