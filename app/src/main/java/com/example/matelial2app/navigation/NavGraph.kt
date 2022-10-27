package com.example.matelial2app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.matelial2app.signup.Login
import com.example.matelial2app.signup.Register
import com.example.matelial2app.signup.WelcomeScreen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Login.route){
            Login(navController)
        }
        composable(route = Screens.Home.route){
            WelcomeScreen(navController)
        }
        composable(route = Screens.Register.route){
            Register(navController)
        }
    }
}