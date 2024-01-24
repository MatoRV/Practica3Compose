package com.example.practica3_matoramosvictor.navigation

sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
    object ButtonScreen: AppScreens("button_screen")
}