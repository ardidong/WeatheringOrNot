package com.ardidong.weatherornot.app.presentation.navigation

sealed class Routes(val route: String){
    object Home: Routes("home")
}
