package com.example.practica3_matoramosvictor.screens.reserva

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.practica3_matoramosvictor.modelo.DataReserva
import com.google.firebase.firestore.FirebaseFirestore

class ReservaViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun subirReserva(reserva: DataReserva) {
        db.collection("reservas")
            .add(reserva)
            .addOnSuccessListener { documentReference ->
                println("Reserva agregada")
            }
            .addOnFailureListener { fail ->
                println("Error al agregar la reserva: $fail")
            }
    }
}