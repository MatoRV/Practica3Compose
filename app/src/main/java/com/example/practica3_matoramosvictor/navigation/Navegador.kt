package com.example.practica3_matoramosvictor.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica3_matoramosvictor.screens.ButtonScreen
import com.example.practica3_matoramosvictor.screens.SecondScreen
import com.example.practica3_matoramosvictor.screens.login.LoginScreen
import com.example.practica3_matoramosvictor.screens.register.RegistrationScreen
import com.example.practica3_matoramosvictor.view.MySootheApp

@Composable
fun AppNavigation(
    windowSizeClass: WindowSizeClass
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SecondScreen.route) {
        composable(route = AppScreens.FirstScreen.route) {
            MySootheApp(windowSizeClass, navController)
        }
        composable(route = AppScreens.SecondScreen.route) {
            SecondScreen(navController, windowSizeClass)
        }
        composable(route = AppScreens.ButtonScreen.route) {
            ButtonScreen(navController, windowSizeClass )
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController, windowSizeClass)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegistrationScreen(navController, windowSizeClass)
        }
    }
}