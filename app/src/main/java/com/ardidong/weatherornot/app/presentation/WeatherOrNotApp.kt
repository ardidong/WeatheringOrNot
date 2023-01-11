package com.ardidong.weatherornot.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ardidong.weatherornot.app.presentation.home.HomeScreen
import com.ardidong.weatherornot.app.presentation.navigation.Routes

@Composable
fun WeatherOrNotApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route){
        composable(Routes.Home.route){
            HomeScreen()
        }
    }
}