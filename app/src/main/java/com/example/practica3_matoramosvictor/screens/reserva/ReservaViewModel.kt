package com.example.practica3_matoramosvictor.screens.reserva

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.practica3_matoramosvictor.modelo.DataReserva
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ReservaViewModel : ViewModel() {
    private val _state = MutableStateFlow(DataReserva())
    val state: StateFlow<DataReserva> = _state.asStateFlow()
    private val reservaFirestore: ReservaFirestore = ReservaFirestore()

    fun addReserva(nombre: String, numPersonas: Int, fecha: String, hora: String) {
        val reservaF : ReservaFirestore = ReservaFirestore()
        val reserva = DataReserva(nombre,numPersonas,fecha,hora)
        reservaF.subirReserva(reserva)
    }

    fun actualizarState(estado: DataReserva) {
        _state.value = estado
    }


}