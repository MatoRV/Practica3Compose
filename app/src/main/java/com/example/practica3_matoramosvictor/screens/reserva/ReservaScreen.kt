package com.example.practica3_matoramosvictor.screens.reserva

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practica3_matoramosvictor.modelo.DataReserva
import com.example.practica3_matoramosvictor.navigation.AppScreens
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme

@Composable
fun ReservaScreen(
    navController: NavController,
    windowSizeClass: WindowSizeClass? = null,
    viewModel: ReservaViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var nombre by remember { mutableStateOf("") }
    var numeroPersonas by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigate(AppScreens.FirstScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "Reserva Restaurante",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = {nombre = it},
                    label = { Text(text = "Nombre")}
                )
                OutlinedTextField(
                    value = numeroPersonas,
                    onValueChange = {numeroPersonas = it},
                    label = { Text(text = "Número de Personas")}
                )
                OutlinedTextField(
                    value = hora,
                    onValueChange = {hora = it},
                    label = { Text(text = "Fecha y hora")}
                )
                Button(
                    onClick = {
                        val reserva = DataReserva(nombre,numeroPersonas.toInt(),hora)
                        viewModel.subirReserva(reserva)
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Reservar")
                }
            }
        )
    }

}

@Preview
@Composable
fun ReservaGridPreview() {
    Practica3MatoRamosVictorTheme {
        ReservaScreen(navController = rememberNavController())
    }
}