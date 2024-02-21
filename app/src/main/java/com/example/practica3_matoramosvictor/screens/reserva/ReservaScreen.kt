package com.example.practica3_matoramosvictor.screens.reserva

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practica3_matoramosvictor.navigation.AppScreens
import com.example.practica3_matoramosvictor.screens.login.RoundedButton
import com.example.practica3_matoramosvictor.screens.login.TransparentTextField
import com.example.practica3_matoramosvictor.ui.theme.Practica3MatoRamosVictorTheme
import java.time.Instant
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservaScreen(
    navController: NavController,
    windowSizeClass: WindowSizeClass? = null,
) {
    val reservaViewModel: ReservaViewModel = viewModel()
    val reservaState by reservaViewModel.state.collectAsState()

    val nombre = rememberSaveable { mutableStateOf("") }
    val numeroPersonas = rememberSaveable { mutableStateOf("") }
    var fecha by rememberSaveable { mutableStateOf("") }
    val hora = rememberSaveable { mutableStateOf("") }
    val datePicker = rememberDatePickerState()
    var showDialog by remember {
        mutableStateOf(false)
    }
    val context: Context = LocalContext.current
    val focusManager = LocalFocusManager.current


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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                TransparentTextField(
                    textFieldValue = nombre,
                    textLabel = "Nombre",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    imeAction = ImeAction.Next
                )
                TransparentTextField(
                    textFieldValue = numeroPersonas,
                    textLabel = "Número de personas",
                    keyboardType = KeyboardType.Number,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    imeAction = ImeAction.Next
                )
                /*
                TransparentTextField(
                    textFieldValue = fecha,
                    textLabel = "Fecha",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    imeAction = ImeAction.Next
                )

                 */
                Button(
                    onClick = { showDialog = true }
                ) {
                    Text(text = "Mostrar fecha")
                }
                if (showDialog) {
                    DatePickerDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = { 
                            Button(
                                onClick = {showDialog = false}
                            ) {
                                Text(text = "Confirmar")
                            }
                        }
                    ) {
                        DatePicker(state = datePicker)
                    }
                }
                val date = datePicker.selectedDateMillis
                date?.let {
                    val localDate =
                        Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
                    fecha = "${localDate.dayOfMonth}/${localDate.monthValue}/${localDate.year}"
                }
                TransparentTextField(
                    textFieldValue = hora,
                    textLabel = "Hora",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    imeAction = ImeAction.Next
                )

                RoundedButton(
                    text = "Reservar",
                    displayProgressBar = false,
                    onClick = {
                        if (nombre.value.isEmpty() || numeroPersonas.value.isEmpty() || fecha.isEmpty() || hora.value.isEmpty()) {
                            Toast.makeText(context,"Hay campos vacíos",Toast.LENGTH_SHORT).show()
                            return@RoundedButton
                        }
                        reservaViewModel.actualizarState(
                            reservaState.copy(
                                nombre = nombre.value,
                                numeroPersonas = numeroPersonas.value.toInt(),
                                fecha = fecha.toString(),
                                hora = hora.value
                            )
                        )
                        reservaViewModel.addReserva(nombre.value,numeroPersonas.value.toInt(),fecha,hora.value)
                    }
                )
            }
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ReservaGridPreview() {
    Practica3MatoRamosVictorTheme {
        ReservaScreen(navController = rememberNavController())
    }
}