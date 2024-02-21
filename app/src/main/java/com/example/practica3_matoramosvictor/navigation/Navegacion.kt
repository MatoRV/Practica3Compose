package com.example.practica3_matoramosvictor.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practica3_matoramosvictor.R
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme

@Composable
fun Navegacion(
    modifier: Modifier = Modifier,
    navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.inicio))
            },
            selected = false,
            onClick = {
                navController.navigate(route = AppScreens.FirstScreen.route)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.segundaPantalla))
            },
            selected = false,
            onClick = {
                navController.navigate(route = AppScreens.ButtonScreen.route)
            }
        )
        NavigationBarItem(
            icon = {
                   Icon(
                       imageVector = Icons.Default.AutoStories,
                       contentDescription = null
                   )
            },
            label = {
                Text(stringResource(R.string.reserva))
            },
            selected = false,
            onClick = {
                navController.navigate(route = AppScreens.ButtonScreen.route)
            }
        )
    }
}
/*
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavegacionPreview() {
    Practica3MatoRamosVictorTheme {
        val navController = rememberNavController()
        Navegacion(Navegacion(Modifier.padding(top = 24.dp), navController = navController))
    }
}

 */