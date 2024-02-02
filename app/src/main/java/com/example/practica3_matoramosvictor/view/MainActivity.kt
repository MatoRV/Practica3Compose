package com.example.practica3_matoramosvictor.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practica3_matoramosvictor.navigation.AppNavigation
import com.example.practica3_matoramosvictor.navigation.Navegacion
import com.example.practica3_matoramosvictor.navigation.NavegacionVerticalF
import com.example.practica3_matoramosvictor.screens.mainscreen.HomeScreen
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Calcula el tamaño de la ventana
            val windowSizeClass = calculateWindowSizeClass(this)

            AppNavigation(windowSizeClass)
        }
    }
}

@Composable
fun MySootheAppPortrait(
    navController: NavController
) {
    Practica3MatoRamosVictorTheme {
        Scaffold(
            bottomBar = { Navegacion(navController = navController) }
        ) {padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait(navController = rememberNavController())
}


@Composable
fun MySootheAppLandscape(
    navController: NavController
) {
    Practica3MatoRamosVictorTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                NavegacionVerticalF(navController = navController)
                HomeScreen()
            }
        }
    }
}

@Preview(widthDp = 640, heightDp = 360)
@Composable
fun MySootheLandscapePreview() {
    MySootheAppLandscape(navController = rememberNavController())
}

@Composable
fun MySootheApp(
    windowSize: WindowSizeClass,
    navController: NavController) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait(navController = navController)
        }
        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape(navController = navController)
        }
    }
}





