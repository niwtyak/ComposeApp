package com.example.matelial2app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.matelial2app.client.RetrofitClient
import com.example.matelial2app.interfaces.RetrofitServices
import com.example.matelial2app.signup.Login
import com.example.matelial2app.signup.Register
import com.example.matelial2app.signup.WelcomeScreen

@Composable
fun NavGraph (navController: NavHostController,retrofitClient: RetrofitServices){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Login.route){
            Login(navController, retrofitClient)
        }
        composable(route = Screens.Home.route){
            WelcomeScreen(navController)
        }
        composable(route = Screens.Register.route){
            Register(navController, retrofitClient)
        }
    }
}