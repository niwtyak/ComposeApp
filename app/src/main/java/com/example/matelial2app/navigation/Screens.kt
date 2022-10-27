package com.example.matelial2app.navigation

sealed class Screens (val route:String){
    object Login:Screens("login")
    object Home:Screens("home")
    object Register:Screens("register")
}